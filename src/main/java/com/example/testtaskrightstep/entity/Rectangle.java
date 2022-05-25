package com.example.testtaskrightstep.entity;

import javax.persistence.Entity;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@Table(name = "RECTANGLE")
@Entity
public class Rectangle extends Figure {

  @Setter
  private double width;
  @Setter
  private double height;
  @Transient
  private double diagonal;

  public Rectangle(double width, double height, Color color) {
    this.width = width;
    this.height = height;
    this.color = color;
  }

  @PostLoad
  private void postLoad() {
    diagonal = Math.sqrt(width * width + height * height);
    perimeter = 2 * (width + height);
    area = width * height;
    figureType = FigureType.RECTANGLE;
  }
}
