package ninja.harmless.vishnu.airport.controller

import ninja.harmless.vishnu.AbstractControllerTest

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
class AirportControllerTest extends AbstractControllerTest {
    @Override
    String baseUrl() {
        return "airport"
    }
    
    @Override
    String postJSON() {
        return '''
            {
                "iataCode" : "ABC",
                "city" : "TEST",
                "countryResource" : { "countryCode" : "AT", "name" : "Austria" }
            }
        '''
    }
}
