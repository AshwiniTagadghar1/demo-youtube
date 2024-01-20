package com.clone.demo.services;

import com.clone.demo.models.Comment;
import com.clone.demo.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Optional<Comment> getCommentById(String id) {
        return commentRepository.findById(id);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public void deleteComment(String id) {
        commentRepository.deleteById(id);
    }

    public Comment saveOrUpdateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // Add other business logic methods as needed
}
