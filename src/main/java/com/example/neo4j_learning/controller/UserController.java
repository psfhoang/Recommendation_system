package com.example.neo4j_learning.controller;

import com.example.neo4j_learning.entity.PersonEntity;
import com.example.neo4j_learning.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
  public ResponseEntity<?> saveUser(@RequestBody PersonEntity userEntity) {
    return ResponseEntity.ok(userService.save(userEntity));
  }

  @GetMapping
  public ResponseEntity<?> getAllUser() {
    return ResponseEntity.ok(userService.getAll());
  }

  @PostMapping("/add-friend")
  public ResponseEntity<Void> addFriend(@RequestParam String from, @RequestParam String to) {
    userService.addFriend(from, to);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/remove-friend")
  public ResponseEntity<Void> removeFriend(@RequestParam Long fromId, @RequestParam Long toId) {
    userService.removeFriend(fromId, toId);
    return ResponseEntity.noContent().build();
  }

}
