package com.example.testtaskrightstep.service;

import com.example.testtaskrightstep.entity.Rectangle;
import com.example.testtaskrightstep.repository.RectangleRepository;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class RectangleService {

  private final RectangleRepository repository;

  public RectangleService(RectangleRepository repository) {
    this.repository = repository;
  }

  public List<Rectangle> getAll() {
    return repository.findAll().stream()
        .sorted(Comparator.comparingDouble(Rectangle::getDiagonal))
        .collect(Collectors.toList());
  }

  public void save(Rectangle rectangle) {
    repository.save(rectangle);
  }
}
