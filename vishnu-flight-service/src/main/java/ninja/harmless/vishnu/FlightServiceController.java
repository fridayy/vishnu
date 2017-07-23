package ninja.harmless.vishnu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author bnjm@harmless.ninja - 7/23/17.
 */
@Controller
public class FlightServiceController {

  @GetMapping("/")
  public ModelAndView frontend() {
    return new ModelAndView("forward://index.html");
  }
}
