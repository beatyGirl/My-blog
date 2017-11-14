package com.tian.blog.common;

import com.tian.blog.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void test01(){
        System.out.println("Spring boot ");
    }

    @Test
    public void test02() throws Exception{
        RequestBuilder e = get("/");
        String response = mockMvc.perform(e).andReturn().getResponse().getContentAsString();
        System.out.println(response);
    }
}
