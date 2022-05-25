package com.example.testtaskrightstep.service;

import com.example.testtaskrightstep.entity.Circle;
import com.example.testtaskrightstep.repository.CircleRepository;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CircleService {

  private final CircleRepository repository;

  public CircleService(CircleRepository repository) {
    this.repository = repository;
  }

  public List<Circle> getAll() {
    return repository.findAll().stream()
        .sorted(Comparator.comparingDouble(Circle::getRadius))
        .collect(Collectors.toList());
  }

  public void save(Circle circle) {
    repository.save(circle);
  }
}
