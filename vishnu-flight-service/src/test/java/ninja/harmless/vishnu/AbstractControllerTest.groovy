package ninja.harmless.vishnu

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@SpringBootTest
@ActiveProfiles("test")
abstract class AbstractControllerTest extends Specification {
    
    MockMvc mockMvc
    
    @Autowired
    WebApplicationContext context
    
    @Value('${api.version}')
    String apiVersion
    
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
    }
    
    @Unroll("GET Request to #endpoint returns correct status")
    void "GET requests"() {
        expect:
            ResultMatcher rm = expectedStatus
            mockMvc.perform(get("/$apiVersion/$endpoint")).andExpect(rm)
        where:
            endpoint             || expectedStatus
            "${baseUrl()}?q=all" || MockMvcResultMatchers.status().isOk()
            "${baseUrl()}"       || MockMvcResultMatchers.status().isOk()
            "${baseUrl()}?q=asd" || MockMvcResultMatchers.status().is4xxClientError()
            "${baseUrl()}/123"   || MockMvcResultMatchers.status().is4xxClientError()
    }
    
    void "POST Request adds a resource"() {
        expect:
            ResultMatcher rm = expectedStatus
            mockMvc.perform(post("/$apiVersion/$endpoint").contentType(MediaType.APPLICATION_JSON_VALUE).content(postJSON())).andExpect(rm)
        where:
            endpoint       || expectedStatus
            "${baseUrl()}" || MockMvcResultMatchers.status().isCreated()
        
    }
    
    abstract String baseUrl()
    
    abstract String postJSON()
}
