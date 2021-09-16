package com.escola.zoomapp.controller;

import com.escola.zoomapp.dto.PostDTO;
import com.escola.zoomapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poster")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDTO> store(@RequestBody PostDTO postDTO) {
        PostDTO postAfterCreate = this.postService.postCreate(postDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(postAfterCreate);
    }
}
