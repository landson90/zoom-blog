package com.escola.zoomapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.zoomapp.dto.PostDTO;
import com.escola.zoomapp.service.PostService;

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
    
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> show(@PathVariable Long id) {
    	PostDTO postDTO = this.postService.postShow(id);
    	return ResponseEntity.ok().body(postDTO);
    }
    
    @GetMapping("/{userId}/usuario")
    public ResponseEntity<List<PostDTO>> toCollectionToPostDTO(@PathVariable Long userId) {
    	List<PostDTO> postDTOs = this.postService.toCollectionPostDTO(userId);
    	return ResponseEntity.ok().body(postDTOs);
    }
}
