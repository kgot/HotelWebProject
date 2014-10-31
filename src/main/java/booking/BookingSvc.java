/**
 * Implements BookingSvcApi.
 */
package booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * @author Gottis Konstantinos
 * @email konstantninos.gottis@gmail.com
 */
public class BookingSvc implements BookingSvcApi {

	@Override
	public double getRoomTypePrice(String type) {
		double price = 0.0;

		if (type.equals(ROOM_TYPE_SINGLE)) {
			price = PRICING_TYPE_SINGLE;
		} else if (type.equals(ROOM_TYPE_DOUBLE)) {
			price = PRICING_TYPE_DOUBLE;
		} else if (type.equals(ROOM_TYPE_TRIPLE)) {
			price = PRICING_TYPE_TRIPLE;
		} else if (type.equals(ROOM_TYPE_QUAD)) {
			price = PRICING_TYPE_QUAD;
		} else if (type.equals(ROOM_TYPE_QUEEN)) {
			price = PRICING_TYPE_QUEEN;
		} else if (type.equals(ROOM_TYPE_KING)) {
			price = PRICING_TYPE_KING;
		} else if (type.equals(ROOM_TYPE_DOUBLE_DOUBLE)) {
			price = PRICING_TYPE_DOUBLE_DOUBLE;
		} else if (type.equals(ROOM_TYPE_MINI_SUITE)) {
			price = PRICING_TYPE_MINI_SUITE;
		} else if (type.equals(ROOM_TYPE_SUITE)) {
			price = PRICING_TYPE_SUITE;
		}
		return price;
	}

	@Override
	public double getDiscount(double price, double discount) {
		return price * (discount / 100);
	}

	@Override
	public double getFinalPrice(Reservation reservation) {
		
		double initialPrice = 0.0;
		double discountChargeSum = 0.0;
				
		initialPrice =  getRoomTypePrice(reservation.getRoomType());
		// apply discounts and charges
		if(reservation.isRegularCustomer()) discountChargeSum -= getDiscount(initialPrice, REGULAR_CUSTOMER_DISCOUNT);
		if(reservation.isNoCancel()) discountChargeSum -= getDiscount(initialPrice, NO_CANCEL_DISCOUNT);
		if(reservation.isHalfBoard()) discountChargeSum += HALF_BOARD_CHARGE;
		if(reservation.isPoolFacility()) discountChargeSum += POOL_CHARGE;
		if(reservation.isSportsFacility()) discountChargeSum += SPORT_FACILITIES_CHARGE;
		if(reservation.isAllInclusive()) discountChargeSum += ALL_INCLUSIVE_CHARGE;		
		System.out.println("early res dicount: " + getEarlyReservationDiscount(reservation.getCheckInDate(), initialPrice));
		
		// charges and discounts apply per day
		return (initialPrice + discountChargeSum) * reservation.getNights() -
				// calculate and add early reservation discount
				getEarlyReservationDiscount(reservation.getCheckInDate(), initialPrice) +			
				// tourist season charges are already calculated per day
				getTouristSeasonCharge(reservation.getCheckInDate(), reservation.getCheckOutDate(), initialPrice); 
	}

	@Override
	public double getTouristSeasonCharge(Date startDate, Date endDate, double price) {
		double seasonCharge = 0.0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Integer startYear = start.get(Calendar.YEAR); 
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		Integer endYear = end.get(Calendar.YEAR);
        
		// string date convertions
        String winterSeasonStart = WINTER_SEASON_START_DATE.concat(startYear.toString());
        String winterSeasonEnd = WINTER_SEASON_END_DATE.concat(endYear.toString());
        String springSeasonStart = SPRING_SEASON_START_DATE.concat(startYear.toString());
        String springSeasonEnd = SPRING_SEASON_END_DATE.concat(endYear.toString());
        String summerSeasonStart = SUMMER_SEASON_START_DATE.concat(startYear.toString());
        String summerSeasonEnd = SUMMER_SEASON_END_DATE.concat(endYear.toString());
        // date convertions
        Date winterSeasonStartDate = new Date();
        Date winterSeasonEndDate = new Date();
        Date springSeasonStartDate = new Date();
        Date springSeasonEndDate = new Date();
        Date summerSeasonStartDate = new Date();
        Date summerSeasonEndDate = new Date();
        // parse date strings
        try {
			winterSeasonStartDate = sdf.parse(winterSeasonStart);
			winterSeasonEndDate = sdf.parse(winterSeasonEnd);
	        springSeasonStartDate = sdf.parse(springSeasonStart);
	        springSeasonEndDate = sdf.parse(springSeasonEnd);
	        summerSeasonStartDate = sdf.parse(summerSeasonStart);
	        summerSeasonEndDate = sdf.parse(summerSeasonEnd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        // interate reservation days
        // check if day falls in tourist season
		for (Date date = start.getTime(); !start.after(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
			// if date is in Winter Season
			if((date.after(winterSeasonStartDate) && (date.before(winterSeasonEndDate))) || 
					(date.equals(sdf.format(winterSeasonStartDate)) || date.equals(sdf.format(winterSeasonEndDate)))){
				// this charge is a percentage
				seasonCharge += price * (TOURIST_SEASON_CHARGE / 100); 
			}
			// if date is in Spring Season
			if((date.after(springSeasonStartDate) && (date.before(springSeasonEndDate))) || 
					(date.equals(sdf.format(springSeasonStartDate)) || date.equals(sdf.format(springSeasonEndDate)))){
				// this charge is a percentage
				seasonCharge += price * (TOURIST_SEASON_CHARGE / 100);
			}
			// if date is in Summer Season
			if((date.after(summerSeasonStartDate) && (date.before(summerSeasonEndDate))) || 
					(date.equals(sdf.format(summerSeasonStartDate)) || date.equals(sdf.format(summerSeasonEndDate)))){
				// this charge is a percentage
				seasonCharge += price * (TOURIST_SEASON_CHARGE / 100);
			}
		}
		return seasonCharge;
	}

	@Override
	public double getEarlyReservationDiscount(Date checkInDate, double price) {
		// joda time objects
		DateTime startDate = new DateTime(checkInDate);
		DateTime curDate = new DateTime();
	
		int days = Days.daysBetween(curDate.withTimeAtStartOfDay(), startDate.withTimeAtStartOfDay()).getDays();
		int monthDiff = days / 30;
		return price * (EARLY_RESERVATION_DISCOUNT / 100) * (double) monthDiff;
	}

}
