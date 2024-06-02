package com.clone.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "Comments")
@Builder
public class Comment {
    @Id
    private String id;
    private String text;
    private String author;

    // Use AtomicInteger for concurrent access
    //private final AtomicInteger likeCount = new AtomicInteger(0);
    //private final AtomicInteger disLikeCount = new AtomicInteger(0);

    // Getter methods are unnecessary with @Data annotation
    // public int likeCount() {
    //     return likeCount.get();
    // }

    // public int disLikeCount() {
    //     return disLikeCount.get();
    // }
}
