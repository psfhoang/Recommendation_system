package com.example.neo4j_learning.controller;

import com.example.neo4j_learning.entity.UserEntity;
import com.example.neo4j_learning.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping()
  public ResponseEntity<?> saveUser(@RequestBody UserEntity userEntity) {
    return ResponseEntity.ok(userService.save(userEntity));
  }

  @PostMapping("/add-friend")
  public ResponseEntity<Void> addFriend(@RequestParam Long fromId, @RequestParam Long toId) {
    userService.addFriend(fromId, toId);
    return ResponseEntity.noContent().build();
  }

}
