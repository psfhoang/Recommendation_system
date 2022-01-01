package com.example.neo4j_learning.service;

import com.example.neo4j_learning.entity.UserEntity;

public interface UserService {

  UserEntity save(UserEntity userEntity);

  void addFriend(Long fromId, Long toId);
}
