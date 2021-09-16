package com.escola.zoomapp.service;

import com.escola.zoomapp.dto.PostDTO;
import com.escola.zoomapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDTO postCreate(PostDTO postDTO) {
        

    }
}
