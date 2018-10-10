package com.mrusanov.spring.boot.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootExampleApplication.class)
@WebAppConfiguration
@ActiveProfiles(value = "test")
public class GreetingRestControllerTest {

    private static final String GREETINGS_URI = "/greetings";

    private static final String POST_GREETING_URI = "/greetings/post";

    private static final String GREETING_NAME_HEADER = "name";

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testPostAndGetGreetings() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(POST_GREETING_URI)
                .content("Hello World!")
                .header(GREETING_NAME_HEADER, "John"))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        mockMvc.perform(MockMvcRequestBuilders.post(POST_GREETING_URI)
                .content("Goodbye World!")
                .header(GREETING_NAME_HEADER, "Jane"))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(GREETINGS_URI)).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

}
