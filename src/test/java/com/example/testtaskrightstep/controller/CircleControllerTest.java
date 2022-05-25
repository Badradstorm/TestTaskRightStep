package com.example.testtaskrightstep.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.testtaskrightstep.entity.Circle;
import com.example.testtaskrightstep.entity.Color;
import com.example.testtaskrightstep.service.CircleService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(CircleController.class)
class CircleControllerTest {

  @MockBean
  private CircleService service;

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Autowired
  private MockMvc mockMvc;

  @Test
  void getAll() throws Exception {
    List<Circle> circles = Collections.singletonList(new Circle(2.0, Color.RED));

    when(service.getAll()).thenReturn(new ArrayList<>(circles));

    this.mockMvc
        .perform(get("/circles"))
        .andExpect(status().isOk())
        .andExpect(content()
            .string(containsString("[{\"id\":0,\"color\":\"RED\",\"perimeter\":0.0,"
                + "\"area\":0.0,\"figureType\":null,\"radius\":2.0}]")))
        .andDo(print());
  }
}