package com.clone.demo.repositories;

import com.clone.demo.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
    // Custom query methods for Comment can be defined here
}
