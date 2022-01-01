package com.example.neo4j_learning.service;

import com.example.neo4j_learning.dto.RankedRestaurant;
import com.example.neo4j_learning.dto.RankedUser;
import com.example.neo4j_learning.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

  public final RestaurantRepository repository;

  @Override
  public Flux<RankedRestaurant> recommendRestaurant() {
    return Flux.fromIterable(repository.recommendRestaurant());
  }
}
