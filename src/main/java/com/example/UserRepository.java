package com.example;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<MovieUser, String> {
    Optional<MovieUser> findByUsername(String username);
}
