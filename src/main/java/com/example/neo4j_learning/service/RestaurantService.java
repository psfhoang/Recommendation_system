package com.example.neo4j_learning.service;

import com.example.neo4j_learning.dto.RankedRestaurant;
import com.example.neo4j_learning.dto.RankedUser;
import reactor.core.publisher.Flux;

public interface RestaurantService {

  Flux<RankedRestaurant> recommendRestaurant();

}
