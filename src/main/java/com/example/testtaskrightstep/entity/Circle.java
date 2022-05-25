package com.example.testtaskrightstep.entity;

import javax.persistence.Entity;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "CIRCLE")
@Entity
public class Circle extends Figure {

  private Double radius;

  public Circle(Double radius, Color color) {
    this.radius = radius;
    this.color = color;
  }

  @PostLoad
  private void postLoad() {
    perimeter = Math.PI * 2 * radius;
    area = Math.PI * (radius * radius);
    figureType = FigureType.CIRCLE;
  }
}
