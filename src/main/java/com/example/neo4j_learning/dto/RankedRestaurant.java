package com.example.neo4j_learning.dto;

import com.example.neo4j_learning.entity.PersonEntity;
import com.example.neo4j_learning.entity.RestaurantEntity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RankedRestaurant {

  private RestaurantEntity restaurant;
  private List<PersonEntity> likers;
  private int occurrences;

}
