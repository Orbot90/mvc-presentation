package ru.mbkcapital.controller;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.mbkcapital.config.TestConfig;
import ru.mbkcapital.configuration.AppConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by orbot on 02.04.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
@WebAppConfiguration
public class ToDoControllerTest extends TestCase {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private static final String TEST_JSON = "{\"name\": \"lol\", \"email\": \"lol@mail.ru\"}";
    private static final String TEST_JSON_2 = "{\"someValue\": \"lol\"}";
    private static final String EXPECTED_RESPONSE = "{\"name\":\"lol after process\",\"email\":\"lol@mail.ru after process\"}";

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testPostRequest() throws Exception {
        mockMvc.perform(post("/process")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TEST_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(EXPECTED_RESPONSE))
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    public void postEntity() throws Exception {
        mockMvc.perform(post("/post_entity")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TEST_JSON_2))
                .andExpect(status().is(201));

        mockMvc.perform(get("/get_entities"))
                .andDo(result -> System.out.println(result.getResponse().getContentAsString()));
    }
}