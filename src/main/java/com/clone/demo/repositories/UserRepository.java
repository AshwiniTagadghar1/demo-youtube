package com.clone.demo.repositories;

import com.clone.demo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
public interface UserRepository extends MongoRepository<User, String> {
    // You can define custom query methods here if needed
    Optional<User> findByEmailAddress(String emailAddress);
}
