package com.example.testtaskrightstep.service;

import com.example.testtaskrightstep.entity.Color;
import com.example.testtaskrightstep.entity.Figure;
import com.example.testtaskrightstep.repository.FigureRepository;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FigureService {

  private final FigureRepository repository;

  public FigureService(FigureRepository repository) {
    this.repository = repository;
  }

  public List<Figure> getAll(String colorName) {
    Color color;
    try {
      color = Color.valueOf(colorName.toUpperCase(Locale.ROOT));
    } catch (IllegalArgumentException e) {
      return repository.findAll().stream()
          .sorted(Comparator.comparingDouble(Figure::getArea))
          .collect(Collectors.toList());
    }
    return repository.findAllByColor(color).stream()
        .sorted(Comparator.comparingDouble(Figure::getArea))
        .collect(Collectors.toList());
  }
}
