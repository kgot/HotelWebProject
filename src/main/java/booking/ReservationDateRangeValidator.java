/**
 * A date range validator class.
 */
package booking;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Gottis Konstantinos
 * @email konstantninos.gottis@gmail.com
 */
public class ReservationDateRangeValidator implements Validator {

	@Override
	public boolean supports(Class<?> customer) {
		return Reservation.class.isAssignableFrom(customer);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Reservation res = (Reservation) obj;
		if ((res.getCheckInDate() != null) && (res.getCheckOutDate() != null)
				&& (res.getCheckOutDate().before(res.getCheckInDate()))) {
			errors.rejectValue("checkOutDate", "field.incorrect", "Invalid check-in and check-out date range.");
		}
	}
}
