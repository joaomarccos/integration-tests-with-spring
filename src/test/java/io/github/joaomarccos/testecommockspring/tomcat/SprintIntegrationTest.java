package io.github.joaomarccos.testecommockspring.tomcat;

import io.github.joaomarccos.testecommockspring.tomcat.service.HelloWorldService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;


/**
 *
 * @author joaomarcos
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SampleTomcatApplication.class)
@WebAppConfiguration
public class SprintIntegrationTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context).build();
    }
    
    @Test
    public void test() throws Exception{
        mvc.perform(get("/")).andExpect(status().isOk());
    }
    
    @Test
    public void testMock(){
        HelloWorldService mock = mock(HelloWorldService.class);
        expect(mock.getHelloMessage()).andReturn("Hello");
        replay(mock);
        
        assertEquals(mock.getHelloMessage(), "Hello");
        verify(mock);
        
    }
    

}
