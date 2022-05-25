package com.example.testtaskrightstep.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Figure {

  @Id
  @GeneratedValue
  private long id;

  @Setter
  @Enumerated(value = EnumType.STRING)
  protected Color color;
  @Transient
  protected double perimeter;
  @Transient
  protected double area;
  @Transient
  protected FigureType figureType;
}
