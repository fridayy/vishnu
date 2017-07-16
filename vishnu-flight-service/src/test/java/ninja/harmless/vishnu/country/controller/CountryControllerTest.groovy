package ninja.harmless.vishnu.country.controller

import ninja.harmless.vishnu.AbstractControllerTest
/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
class CountryControllerTest extends AbstractControllerTest {
    @Override
    String baseUrl() {
        return "country"
    }
    
    @Override
    String postJSON() {
        return '''
            { "countryCode" : "AT", "name" : "Austria" }
        '''
    }
}
