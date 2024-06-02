package com.clone.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "Videos")
@Builder
public class Video {
    @Id
    private String id;
    private String title;
    private String description;
    private String userId;
    private final AtomicInteger likes = new AtomicInteger(0);
    private final AtomicInteger disLikes = new AtomicInteger(0);
    @Builder.Default
    private List<String> tags = new ArrayList<>(); // Set as default for builder
    private String url;
    private VideoStatus videoStatus;
    private final AtomicInteger viewCount = new AtomicInteger(0);
    private String thumbnailUrl;
    private final List<Comment> comments = new ArrayList<>();
}

enum VideoStatus {
    PENDING,
    APPROVED,
    REJECTED
}
