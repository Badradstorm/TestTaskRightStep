package com.example.testtaskrightstep.controller;

import com.example.testtaskrightstep.entity.Rectangle;
import com.example.testtaskrightstep.service.RectangleService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rectangles")
public class RectangleController {

  private final RectangleService service;

  public RectangleController(RectangleService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<Rectangle>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }
}
