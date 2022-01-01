package com.example.neo4j_learning.service;

import com.example.neo4j_learning.entity.UserEntity;
import com.example.neo4j_learning.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public UserEntity save(UserEntity userEntity) {
    return userRepository.save(userEntity);
  }

  @Override
  public void addFriend(Long fromId, Long toId) {
    userRepository.addFriend(fromId, toId);
  }
}
