package com.escola.zoomapp.service;

import com.escola.zoomapp.dto.PostDTO;
import com.escola.zoomapp.mapper.poster.PostDTOAssembler;
import com.escola.zoomapp.mapper.poster.PostEntityAssemble;
import com.escola.zoomapp.model.Post;
import com.escola.zoomapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostRepository postRepository;
    private PostDTOAssembler postDTOAssembler;
    private PostEntityAssemble postEntityAssemble;

    @Autowired
    public PostService(PostRepository postRepository, PostDTOAssembler postDTOAssembler, PostEntityAssemble postEntityAssemble) {
        this.postRepository = postRepository;
        this.postDTOAssembler = postDTOAssembler;
        this.postEntityAssemble = postEntityAssemble;
    }

    public PostDTO postCreate(PostDTO postDTO) {
        Post post = this.postEntityAssemble.toModel(postDTO);
        Post create = this.postRepository.save(post);
      
        return this.postDTOAssembler.toModel(create);
    }
}
