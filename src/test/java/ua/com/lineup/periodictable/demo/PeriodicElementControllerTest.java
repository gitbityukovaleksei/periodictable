package ua.com.lineup.periodictable.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ua.com.lineup.periodictable.controller.PeriodicElementController;
import ua.com.lineup.periodictable.service.ElementService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@EnableWebMvc
public class PeriodicElementControllerTest {

    MockMvc mockMvc;
    @Autowired
    ElementService elementService;

    @BeforeEach
    public void setup() {
        PeriodicElementController periodicElementController = new PeriodicElementController(elementService);

        mockMvc = MockMvcBuilders.standaloneSetup(periodicElementController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
    }

    @ParameterizedTest(name = "#{index} - Run test with args={0}")
    @ValueSource(strings = {"Samarium"})
    void testPeriodicElementControllerWithFilterByName(String name) throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/periodic/get-all?name=" + name)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String response = result.getResponse().getContentAsString();

        assertNotNull(response);
        assertEquals("[{\"name\":\"Samarium\",\"atomicNumber\":62,\"alternativeName\":\"n/a\",\"symbol\":\"Sm\",\"appearance\":\"silvery white\",\"discovery\":\"n/a\",\"discoveryYear\":null,\"groupBlock\":0,\"period\":6}]",response);
    }

    @Test
    void testPeriodicElementControllerWithBasicPageable() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/periodic/get-all?sort=atomicNumber,desc&size=40")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String response = result.getResponse().getContentAsString();

        assertNotNull(response);
    }



}
