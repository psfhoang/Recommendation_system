package com.example.neo4j_learning.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.id.UuidStrategy;

@NodeEntity(value = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

  @Id
  @GeneratedValue(strategy = UuidStrategy.class)
  private String id;
  private Long userId;
  private String name;

  public UserEntity(String name) {
    this.name = name;
  }
}
