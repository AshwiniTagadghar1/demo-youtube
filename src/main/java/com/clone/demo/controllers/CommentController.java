package com.clone.demo.controllers;

import com.clone.demo.models.Comment;
import com.clone.demo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments") // Base path for all endpoints in this controller
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // POST /api/comments - Create or update a comment
    @PostMapping
    public ResponseEntity<Comment> createOrUpdateComment(@RequestBody Comment comment) {
        Comment savedComment = commentService.saveOrUpdateComment(comment);
        return ResponseEntity.ok(savedComment);
    }

    // GET /api/comments/{id} - Get a comment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Comment> getUserById(@PathVariable String id) {
        Optional<Comment> comment = commentService.getCommentById(id);
        return comment.isPresent() ? ResponseEntity.ok(comment.get()) : ResponseEntity.notFound().build();
    }

    // GET /api/comments - Get all comments
    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    // DELETE /api/comments/{id} - Delete a comment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable String id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
    }

    // Additional endpoints can be added as needed.
}