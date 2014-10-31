/**
 * A POJO Reservation class.
 */
package booking;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Terminal
 *
 */
public class Reservation {

	@NotEmpty(message = "*A name is required.")
	@Size(max = 30, message = "*Maximum 30 characters.")
	private String customerName;

	@NotEmpty(message = "*A surname is required.")
	@Size(max = 30, message = "*Maximum 30 characters.")
	private String customerSurname;

	@NotEmpty(message = "*An email address is required.")
	@Email(message = "*Not a valid email.")
	private String customerEmail;

	@NotNull(message = "*A check-in date is required.")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Future(message = "Invalid check-in date.")
	private Date checkInDate;

	@NotNull(message = "*A check-out date is required.")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Future(message = "Invalid check-out date.")
	private Date checkOutDate;

	@NotNull
	private String roomType; 

	private boolean regularCustomer;

	private boolean noCancel;

	private boolean halfBoard;

	private boolean allInclusive;

	private boolean sportsFacility;

	private boolean poolFacility;
	
	/**
	 * Returns the total number of nights.
	 * @return number of nights
	 */
	public double getNights() {
		return (double) ((checkOutDate.getTime() - checkInDate.getTime()) / 1000 / 60 / 60 / 24);
	}
	
	/**
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	/**
	 * @return the regularCustomer
	 */
	public boolean isRegularCustomer() {
		return regularCustomer;
	}

	/**
	 * @param regularCustomer the regularCustomer to set
	 */
	public void setRegularCustomer(boolean regularCustomer) {
		this.regularCustomer = regularCustomer;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerSurname
	 */
	public String getCustomerSurname() {
		return customerSurname;
	}

	/**
	 * @param customerSurname the customerSurname to set
	 */
	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * @return the startDate
	 */
	public Date getCheckInDate() {
		return checkInDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setCheckInDate(Date startDate) {
		this.checkInDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setCheckOutDate(Date endDate) {
		this.checkOutDate = endDate;
	}

	/**
	 * @return the noCancel
	 */
	public boolean isNoCancel() {
		return noCancel;
	}

	/**
	 * @param noCancel the noCancel to set
	 */
	public void setNoCancel(boolean noCancel) {
		this.noCancel = noCancel;
	}

	/**
	 * @return the halfBoard
	 */
	public boolean isHalfBoard() {
		return halfBoard;
	}

	/**
	 * @param halfBoard the halfBoard to set
	 */
	public void setHalfBoard(boolean halfBoard) {
		this.halfBoard = halfBoard;
	}

	/**
	 * @return the allInclusive
	 */
	public boolean isAllInclusive() {
		return allInclusive;
	}

	/**
	 * @param allInclusive the allInclusive to set
	 */
	public void setAllInclusive(boolean allInclusive) {
		this.allInclusive = allInclusive;
	}

	/**
	 * @return the sportsFacility
	 */
	public boolean isSportsFacility() {
		return sportsFacility;
	}

	/**
	 * @param sportsFacility the sportsFacility to set
	 */
	public void setSportsFacility(boolean sportsFacility) {
		this.sportsFacility = sportsFacility;
	}

	/**
	 * @return the poolFacility
	 */
	public boolean isPoolFacility() {
		return poolFacility;
	}

	/**
	 * @param poolFacility the poolFacility to set
	 */
	public void setPoolFacility(boolean poolFacility) {
		this.poolFacility = poolFacility;
	}
	
	
}
