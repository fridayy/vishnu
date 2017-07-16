package ninja.harmless.vishnu.airline.controller

import ninja.harmless.vishnu.AbstractControllerTest
/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
class AirlineControllerTest extends AbstractControllerTest {
    
    @Override
    String baseUrl() {
        return "airline"
    }
    
    @Override
    String postJSON() {
        return '''
         {
            "name" : "TESTAirline"
         }
        '''
    }
}
