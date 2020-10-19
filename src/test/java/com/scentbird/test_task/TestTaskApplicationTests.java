package com.scentbird.test_task;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =
        SpringBootTest.WebEnvironment.MOCK,
        classes = TestTaskApplication.class)
@AutoConfigureMockMvc
public class TestTaskApplicationTests {
    final String jsonBody = "{\n" +
            "    \"countries\":[\n" +
            "        \"kazakhstan\",\n" +
            "        \"russia\"\n" +
            "    ],\n" +
            "    \"beginDate\":\"2020-09-01T00:00:00Z\",\n" +
            "    \"endDate\":\"2020-10-01T00:00:00Z\"\n" +
            "}";
    @Autowired
    private MockMvc mvc;

    @Test
    public void testStatsByList() throws Exception {
        MvcResult result = mvc.perform(get("/v1/statsByList")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        HashMap<String, String> map = new ObjectMapper()
                .readValue(result.getResponse().getContentAsString(),
                        new TypeReference<>() {
                        });
        Assert.assertEquals("8835", map.get("maxConfirmed"));
        Assert.assertEquals("45", map.get("minConfirmed"));
    }

}
