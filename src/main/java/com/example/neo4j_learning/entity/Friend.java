package com.example.neo4j_learning.entity;

import java.util.Objects;
import lombok.ToString;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@ToString
@RelationshipEntity("FRIEND")
public class Friend {

  @Id
  @GeneratedValue
  private Long id;

  @StartNode
  private UserEntity user;

  @EndNode
  private UserEntity friend;

  public Friend() {
  }

  public Friend(UserEntity user, UserEntity friend) {
    this.user = user;
    this.friend = friend;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public UserEntity getFriend() {
    return friend;
  }

  public void setFriend(UserEntity friend) {
    this.friend = friend;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Friend friend1 = (Friend) o;
    return Objects.equals(id, friend1.id) &&
        Objects.equals(user, friend1.user) &&
        Objects.equals(friend, friend1.friend);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, user, friend);
  }
}

