package com.example.springbootblogapplication.services;

import java.time.LocalDateTime;
import java.util.List;
import com.example.springbootblogapplication.models.Post;
import com.example.springbootblogapplication.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post save(Post post) {
        if (post.getId() == 0L) {
            post.setCreatedAt(LocalDateTime.now());
        }
        return postRepository.save(post);
    }
}
