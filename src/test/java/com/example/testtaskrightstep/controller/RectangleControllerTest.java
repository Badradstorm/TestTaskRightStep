package com.example.testtaskrightstep.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.testtaskrightstep.entity.Color;
import com.example.testtaskrightstep.entity.Rectangle;
import com.example.testtaskrightstep.service.RectangleService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RectangleController.class)
class RectangleControllerTest {

  @MockBean
  private RectangleService service;

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Autowired
  private MockMvc mockMvc;

  @Test
  void getAll() throws Exception {
    List<Rectangle> rectangles = Collections.singletonList(new Rectangle(2.0,3.0, Color.RED));

    when(service.getAll()).thenReturn(new ArrayList<>(rectangles));

    this.mockMvc
        .perform(get("/rectangles"))
        .andExpect(status().isOk())
        .andExpect(content()
            .string(containsString("[{\"id\":0,\"color\":\"RED\",\"perimeter\":0.0,"
                + "\"area\":0.0,\"figureType\":null,\"width\":2.0,\"height\":3.0,\"diagonal\":0.0}]")))
        .andDo(print());
  }
}