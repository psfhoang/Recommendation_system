package com.example.neo4j_learning.service;

import com.example.neo4j_learning.entity.PersonEntity;

public interface UserService {

  PersonEntity save(PersonEntity userEntity);

  void addFriend(String fromId, String toId);

  void removeFriend(Long fromId, Long toId);

  Iterable<PersonEntity> getAll();
}
