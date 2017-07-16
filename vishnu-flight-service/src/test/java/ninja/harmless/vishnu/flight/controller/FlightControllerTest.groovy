package ninja.harmless.vishnu.flight.controller

import ninja.harmless.vishnu.AbstractControllerTest
import org.junit.Ignore

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Ignore
class FlightControllerTest extends AbstractControllerTest {
    @Override
    String baseUrl() {
        return "flight"
    }
    
    @Override
    String postJSON() {
        return null
    }
}
