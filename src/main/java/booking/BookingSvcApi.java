/**
 * 
 */
package booking;

import java.util.Date;

/**
 * @author Gottis Konstantinos
 * @email konstantninos.gottis@gmail.com
 */
public interface BookingSvcApi {
	
	// Hardwired variables.  
	// Those variables should be accessible by a real deployed system and 
	// accessed by an administration panel.

	// room types
	public static final String ROOM_TYPE_SINGLE = "Single";
	public static final String ROOM_TYPE_DOUBLE = "Double";
	public static final String ROOM_TYPE_TRIPLE = "Triple";
	public static final String ROOM_TYPE_QUAD = "Quad";
	public static final String ROOM_TYPE_QUEEN = "Queen";
	public static final String ROOM_TYPE_KING = "King";
	public static final String ROOM_TYPE_DOUBLE_DOUBLE = "Double-double";
	public static final String ROOM_TYPE_MINI_SUITE = "Mini-Suite";
	public static final String ROOM_TYPE_SUITE = "Suite";
	
	// pricing
	public static final double PRICING_TYPE_SINGLE = 30;
	public static final double PRICING_TYPE_DOUBLE = 40;
	public static final double PRICING_TYPE_TRIPLE = 50;
	public static final double PRICING_TYPE_QUAD = 60;
	public static final double PRICING_TYPE_QUEEN = 35;
	public static final double PRICING_TYPE_KING = 45;
	public static final double PRICING_TYPE_DOUBLE_DOUBLE = 80;
	public static final double PRICING_TYPE_MINI_SUITE = 100;
	public static final double PRICING_TYPE_SUITE = 120;
	
	// amenities
	public static final double NO_CANCEL_DISCOUNT = 25; // percent
	public static final double POOL_CHARGE = 10;
	public static final double HALF_BOARD_CHARGE = 10;
	public static final double ALL_INCLUSIVE_CHARGE = 40;
	public static final double SPORT_FACILITIES_CHARGE = 10;
	
	// other discounts-charges
	public static final double REGULAR_CUSTOMER_DISCOUNT = 5; // percent
	public static final double EARLY_RESERVATION_DISCOUNT = 5;  //percent
	public static final double TOURIST_SEASON_CHARGE = 10; // percent	
	
	// tourist seasons
	public static final String WINTER_SEASON_START_DATE = "15/12/";
	public static final String WINTER_SEASON_END_DATE = "15/01/";
	public static final String SPRING_SEASON_START_DATE = "15/04/";
	public static final String SPRING_SEASON_END_DATE = "01/05/";
	public static final String SUMMER_SEASON_START_DATE = "10/07/";
	public static final String SUMMER_SEASON_END_DATE = "10/09/";
	
	/**
	 * Assigns pricings to room types.
	 * @param type
	 * @return price
	 */
	public double getRoomTypePrice(String type);
	
	/**
	 * Calculates final price with discounts and charges.
	 * @param reservation
	 * @return final price
	 */
	public double getFinalPrice(Reservation reservation);
	
	/**
	 * Calculates discount sum.
	 * @param price
	 * @param discount
	 * @return discount
	 */
	public double getDiscount(double price, double discount);
	
	/**
	 * Calculates charges for tourist seasons days.
	 * @param startDate
	 * @param endDate
	 * @param price
	 * @return tourist season charge
	 */
	public double getTouristSeasonCharge(Date startDate, Date endDate, double price);
	
	/**
	 * Calculates discount for early reservation.
	 * Price is decreased for every month before check-in date. 
	 * The joda time library was used for calulations between dates.
	 * @param startDate
	 * @param price
	 * @return early reservation dicount
	 */
	public double getEarlyReservationDiscount(Date checkInDate, double price);

}
