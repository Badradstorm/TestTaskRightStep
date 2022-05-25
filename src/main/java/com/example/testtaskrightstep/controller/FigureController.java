package com.example.testtaskrightstep.controller;

import com.example.testtaskrightstep.entity.Figure;
import com.example.testtaskrightstep.service.FigureService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/figures")
public class FigureController {

  private final FigureService service;

  public FigureController(FigureService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<Figure>> getAll(@RequestParam("c") String colorName) {
    return ResponseEntity.ok(service.getAll(colorName));
  }
}
