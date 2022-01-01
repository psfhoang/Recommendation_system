package com.example.neo4j_learning.service;

import com.example.neo4j_learning.entity.PersonEntity;
import com.example.neo4j_learning.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public PersonEntity save(PersonEntity userEntity) {
    return userRepository.save(userEntity);
  }

  @Override
  public void addFriend(String from, String to) {
    userRepository.addFriend(from, to);
  }

  @Override
  public void removeFriend(Long fromId, Long toId) {
    userRepository.removeFriend(fromId, toId);

  }

  @Override
  public Iterable<PersonEntity> getAll() {
    return userRepository.findAll();
  }
}
