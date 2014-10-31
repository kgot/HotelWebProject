/**
 * 
 */
package booking;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Gottis Konstantinos
 * @email konstantninos.gottis@gmail.com
 */
@Controller
public class HotelController {
	
	@Autowired
	private BookingSvcApi booking;
	
	/**
	 * Mapping to index page.
	 * @return index
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
    public String index() {
        return "index";
    }
	
	/**
	 * Mapping to index page.
	 * @return index
	 */
	@RequestMapping(value="/index", method=RequestMethod.GET)
    public String index2() {
        return "index";
    }
	
	/**
	 * Mapping to reservation page.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/reservation", method=RequestMethod.GET)
    public String reservationForm(Model model) {
		model.addAttribute("reservation", new Reservation());
		model.addAttribute("price", 0.0);
        return "reservation";
    }
	
	/**
	 * Mapping to reservation page for submiting a reservation form. This method
	 * is responsible for validating input and getting the final price.
	 * @param reservation
	 * @param bindingResult
	 * @param model
	 * @return reservation
	 */
	@RequestMapping(value = "/reservation", method = RequestMethod.POST)
	public String reservationSubmit(@Valid @ModelAttribute Reservation reservation, BindingResult bindingResult, Model model) {
		// date range validation
		// check if check-out date is before check-in date 
		ReservationDateRangeValidator reservationDaterValidator = new ReservationDateRangeValidator();
		reservationDaterValidator.validate(reservation, bindingResult);

		double finalPrice = 0.0;
				
		if (bindingResult.hasErrors()) {
			model.addAttribute("price", 0.0);
			return "reservation";
		} else {
			finalPrice = booking.getFinalPrice(reservation);
			model.addAttribute("price", finalPrice);
		}
		return "reservation";
	}
	
	/**
	 * Mapping to rooms page.
	 * @return contact
	 */
	@RequestMapping(value="/rooms", method=RequestMethod.GET)
    public String rooms() {
        return "rooms";
    }
	
	/**
	 * Mapping to contacts page.
	 * @return contact
	 */
	@RequestMapping(value="/contact", method=RequestMethod.GET)
    public String contact() {
        return "contact";
    }

}
