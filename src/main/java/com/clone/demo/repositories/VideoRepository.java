package com.clone.demo.repositories;

import com.clone.demo.models.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video, String> {
    // Custom query methods for Video can be defined here
}
