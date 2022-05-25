package com.example.testtaskrightstep.repository;

import com.example.testtaskrightstep.entity.Color;
import com.example.testtaskrightstep.entity.Figure;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FigureRepository extends JpaRepository<Figure, Long> {

  List<Figure> findAllByColor(Color color);
}
