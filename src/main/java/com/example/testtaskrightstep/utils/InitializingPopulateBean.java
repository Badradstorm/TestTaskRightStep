package com.example.testtaskrightstep.utils;

import com.example.testtaskrightstep.entity.Circle;
import com.example.testtaskrightstep.entity.Color;
import com.example.testtaskrightstep.entity.Rectangle;
import com.example.testtaskrightstep.service.CircleService;
import com.example.testtaskrightstep.service.RectangleService;
import java.util.Arrays;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InitializingPopulateBean implements InitializingBean {

  private final CircleService circleService;
  private final RectangleService rectangleService;

  public InitializingPopulateBean(
      CircleService circleService, RectangleService rectangleService) {
    this.circleService = circleService;
    this.rectangleService = rectangleService;
  }

  @Override
  public void afterPropertiesSet() {
    Circle[] circles = {
        new Circle(2.0, Color.RED),
        new Circle(3.0, Color.GREEN),
        new Circle(1.0, Color.BLUE),
        new Circle(4.0, Color.RED),
    };
    Arrays.stream(circles).forEach(circleService::save);

    Rectangle[] rectangles = {
        new Rectangle(2.0, 3.0, Color.BLACK),
        new Rectangle(3.0, 4.0, Color.RED),
        new Rectangle(2.0, 4.0, Color.BLACK),
        new Rectangle(1.0, 2.0, Color.WHITE),
    };
    Arrays.stream(rectangles).forEach(rectangleService::save);
  }
}
