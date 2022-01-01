package com.example.neo4j_learning;

import com.example.neo4j_learning.entity.UserEntity;
import com.example.neo4j_learning.repository.UserRepository;
import java.util.LinkedList;
import java.util.List;
import org.neo4j.ogm.session.Neo4jSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties
public class Neo4jLearningApplication {

  public static void main(String[] args) {
    SpringApplication.run(Neo4jLearningApplication.class, args);
  }

  @Autowired
  private UserRepository userRepository;


  @Bean
  public CommandLineRunner commandLineRunner() {

    return args -> {
      List<UserEntity> userEntityList = new LinkedList<>();
      userEntityList.add(new UserEntity("hoang1"));
      userEntityList.add(new UserEntity("hoang2"));
      userRepository.deleteAll();
      userRepository.saveAll(userEntityList);
    };
  }

}
