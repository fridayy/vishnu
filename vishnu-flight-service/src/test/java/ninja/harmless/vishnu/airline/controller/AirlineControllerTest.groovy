package ninja.harmless.vishnu.airline.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification
/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@SpringBootTest
class AirlineControllerTest extends Specification {
    
    MockMvc mockMvc
    
    @Autowired
    WebApplicationContext context
    
    @Value('${api.version}')
    String apiVersion
    
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
    }
    
    void "GET Request to #endpoint returns #expectedStatus"() {
        expect:
            ResultMatcher rm = expectedStatus
            mockMvc.perform(MockMvcRequestBuilders.get("/$apiVersion/$endpoint")).andExpect(rm)
        where:
            endpoint         || expectedStatus
            "airline?q=all" || MockMvcResultMatchers.status().isOk()
    }
}
