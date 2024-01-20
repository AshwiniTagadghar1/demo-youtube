package com.clone.demo.services;

import com.clone.demo.models.Video;
import com.clone.demo.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video saveVideo(Video video) {
        return videoRepository.save(video);
    }

    public Optional<Video> getVideoById(String id) {
        return videoRepository.findById(id);
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public void deleteVideo(String id) {
        videoRepository.deleteById(id);
    }

    // Add other business logic methods as needed
}
