package com.example.neo4j_learning.controller;

import com.example.neo4j_learning.dto.RankedRestaurant;
import com.example.neo4j_learning.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

  private final RestaurantService service;

  @GetMapping("/recommend")
  public Flux<RankedRestaurant> recommendRestaurant() {
    return service.recommendRestaurant();
  }

}
