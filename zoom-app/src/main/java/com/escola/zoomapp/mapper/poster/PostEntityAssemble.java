package com.escola.zoomapp.mapper.poster;

import com.escola.zoomapp.dto.PostDTO;
import com.escola.zoomapp.model.Post;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostEntityAssemble {

    @Autowired
    private ModelMapper modelMapper;

    public Post toModel(PostDTO postDTO) {
        return modelMapper.map(postDTO, Post.class);
    }


}
