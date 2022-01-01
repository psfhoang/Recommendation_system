package com.example.neo4j_learning.repository;

import com.example.neo4j_learning.entity.UserEntity;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends Neo4jRepository<UserEntity, Long> {

  @Query("MATCH (userA:User), (userB:User)" +
      "WHERE userA.id = {fromId} AND userB.id = {toId} " +
      "CREATE (userA)-[:FRIEND]->(userB)")
  void addFriend(@Param("fromId") Long fromId, @Param("toId") Long toId);
}
