package com.escola.zoomapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.escola.zoomapp.dto.PostDTO;
import com.escola.zoomapp.exception.EntityNotFoundException;
import com.escola.zoomapp.mapper.poster.PostDTOAssembler;
import com.escola.zoomapp.mapper.poster.PostEntityAssemble;
import com.escola.zoomapp.model.Post;
import com.escola.zoomapp.repository.PostRepository;

@Service
public class PostService {

	  private static final String MSG_POST_NAO_ENCONTRDO
      = "Não existe Poster com esse código %d.";
	  private static final String MSG_USUARIO_NAO_ENCONTRDO
      = "Não existe usuário com esse código %d.";
	  
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
    	try {
    		Post post = this.postEntityAssemble.toModel(postDTO);
            PostDTO postCreateDTO = this.postDTOAssembler.toModel(this.postRepository.save(post));
            return postCreateDTO;
    	} catch (DataIntegrityViolationException e) {
    		throw new EntityNotFoundException(String.format(MSG_USUARIO_NAO_ENCONTRDO, postDTO.getUser().getId()));
		}
        
    }

	public PostDTO postShow(Long id) {
		Post post = this.searchOrFailEntity(id);
		return this.postDTOAssembler.toModel(post);
	}

	public List<PostDTO> toCollectionPostDTO(Long userId) {
		try {
			List<Post> posts = this.postRepository.collectionPostUserId(userId);
			return this.postDTOAssembler.toCollectionModel(posts);
		} catch (Exception e) {
			 throw new EntityNotFoundException(String.format(MSG_USUARIO_NAO_ENCONTRDO, userId));
		}
		
	}
	
	private Post searchOrFailEntity(Long id) {
        return this.postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format(MSG_POST_NAO_ENCONTRDO, id)
                ));
    }

}
