package com.example.testtaskrightstep.controller;

import com.example.testtaskrightstep.entity.Circle;
import com.example.testtaskrightstep.service.CircleService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/circles")
public class CircleController {

  private final CircleService service;

  public CircleController(CircleService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<Circle>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }
}
