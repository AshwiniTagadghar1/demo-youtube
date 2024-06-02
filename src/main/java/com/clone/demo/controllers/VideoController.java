package com.clone.demo.controllers;

import com.clone.demo.models.Video;
import com.clone.demo.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/videos") // Base path for all endpoints in this controller
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    // POST /api/videos - Create or update a video
    @PostMapping
    public ResponseEntity<Video> createOrUpdateVideo(@RequestBody Video video) {
        Video savedVideo = videoService.saveVideo(video);
        return ResponseEntity.ok(savedVideo);
    }

    // GET /api/videos/{id} - Get a video by ID
    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable String id) {
        Optional<Video> video = videoService.getVideoById(id);
        return video.isPresent() ? ResponseEntity.ok(video.get()) : ResponseEntity.notFound().build();
    }
    

    // GET /api/videos - Get all videos
    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos() {
        List<Video> videos = videoService.getAllVideos();
        return ResponseEntity.ok(videos);
    }

    // DELETE /api/videos/{id} - Delete a video by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVideo(@PathVariable String id) {
        videoService.deleteVideo(id);
        return ResponseEntity.ok().build();
    }

    // Additional endpoints can be added as needed.
}
