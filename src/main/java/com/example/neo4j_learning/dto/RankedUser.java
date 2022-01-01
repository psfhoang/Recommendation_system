package com.example.neo4j_learning.dto;

import com.example.neo4j_learning.entity.PersonEntity;
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
public class RankedUser {

  private PersonEntity person;
  private Integer weight;

}