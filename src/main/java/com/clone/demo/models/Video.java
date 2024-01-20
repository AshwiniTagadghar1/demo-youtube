package com.clone.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Document(value = "Videos")
    @Builder
    public class Video {
        private String id;
        private String title;
        private String description;
        private String userId;
        private AtomicInteger likes = new AtomicInteger(0);
        private AtomicInteger disLikes = new AtomicInteger(0);
        private List<String> tags;
        private String url;
        private VideoStatus videoStatus;
        private AtomicInteger viewCount = new AtomicInteger(0);
        private String thumbnailUrl;
        private List<Comment> comments = new ArrayList<>();

    }
