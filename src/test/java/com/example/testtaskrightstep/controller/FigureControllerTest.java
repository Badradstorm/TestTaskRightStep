package com.example.testtaskrightstep.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.testtaskrightstep.entity.Circle;
import com.example.testtaskrightstep.entity.Color;
import com.example.testtaskrightstep.entity.Figure;
import com.example.testtaskrightstep.service.FigureService;
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

@WebMvcTest(FigureController.class)
class FigureControllerTest {

  @MockBean
  private FigureService service;

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Autowired
  private MockMvc mockMvc;

  @Test
  void getAll() throws Exception {
    List<Figure> figures = Collections.singletonList(new Circle(2.0, Color.RED));

    when(service.getAll(anyString())).thenReturn(new ArrayList<>(figures));

    this.mockMvc
        .perform(get("/figures")
            .queryParam("c", "red"))
        .andExpect(status().isOk())
        .andExpect(content()
            .string(containsString("[{\"id\":0,\"color\":\"RED\",\"perimeter\":0.0,"
                + "\"area\":0.0,\"figureType\":null,\"radius\":2.0}]")))
        .andDo(print());
  }
}