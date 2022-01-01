package com.example.neo4j_learning.repository;

import com.example.neo4j_learning.dto.RankedUser;
import com.example.neo4j_learning.entity.PersonEntity;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.util.Streamable;

public interface UserRepository extends Neo4jRepository<PersonEntity, Long> {

  @Query("MATCH (personA:Person), (personB:Person) " +
      "WHERE personA.name = $from AND personB.name = $to " +
      "CREATE (personA)-[:IS_FRIEND_OF]->(personB)")
  void addFriend(String from, String to);

  @Query("MATCH (personA:Person), (personB:Person)\n" +
      "WHERE personA.name= $from AND personB.name= $to\n" +
      "MATCH (personA)-[:IS_FRIEND_OF]-(fof:Person)-[:IS_FRIEND_OF]-(personB)\n" +
      "RETURN DISTINCT fof")
  Streamable<PersonEntity> mutualFriends(String from, String to);

  @Query("MATCH (me:Person {userId: $name})-[:IS_FRIEND_OF]-(friends),\n" +
      "\t(nonFriend:Person)-[:IS_FRIEND_OF]-(friends)\n" +
      "WHERE NOT (me)-[:IS_FRIEND_OF]-(nonFriend)\n" +
      "WITH nonFriend, count(nonFriend) as mutualFriends\n" +
      "RETURN nonFriend as Person, mutualFriends as Weight\n" +
      "ORDER BY Weight DESC")
  Streamable<RankedUser> recommendedFriends(String name);

  @Query("MATCH (userA:Person)-[r:IS_FRIEND_OF]->(userB:Person) " +
      "WHERE userA.userId= $fromId AND userB.userId= $toId " +
      "DELETE r")
  void removeFriend(Long fromId, Long toId);
}
