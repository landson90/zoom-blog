package com.escola.zoomapp.mapper.poster;

import com.escola.zoomapp.dto.PostDTO;
import com.escola.zoomapp.model.Post;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostDTOAssembler {

	@Autowired
    private ModelMapper modelMapper;

    public PostDTO toModel(Post post) {
        return modelMapper.map(post, PostDTO.class);
    }

    public List<PostDTO> toCollectionModel(List<Post> postCollection) {
        return postCollection.stream().map(p -> toModel(p)).collect(Collectors.toList());
    }
}
