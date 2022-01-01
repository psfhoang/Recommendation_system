package com.example.neo4j_learning.repository;

import com.example.neo4j_learning.dto.RankedRestaurant;
import com.example.neo4j_learning.entity.RestaurantEntity;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends Neo4jRepository<RestaurantEntity, Long> {

  @Query("MATCH (restaurant:Restaurant)-[:LOCATED_IN]->(location), "
      + "      (restaurant)-[:SERVES]->(cuisine), "
      + "      (person:Person)-[:LIKES]->(restaurant) "
      + "RETURN restaurant, collect(person) as likers, count(*) as occurrences "
      + "ORDER BY occurrences DESC")
  Streamable<RankedRestaurant> recommendRestaurant();

}
