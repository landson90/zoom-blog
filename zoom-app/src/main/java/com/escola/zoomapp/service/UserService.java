package com.escola.zoomapp.service;


import java.util.Optional;

import com.escola.zoomapp.exception.enums.ErrorMessageStatus;
import org.springframework.stereotype.Service;

import com.escola.zoomapp.dto.UserDTO;
import com.escola.zoomapp.exception.EntityNotFoundException;
import com.escola.zoomapp.mapper.user.UserDTOAssembler;
import com.escola.zoomapp.mapper.user.UserEntityAssembler;
import com.escola.zoomapp.model.User;
import com.escola.zoomapp.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserDTOAssembler userDTOAssembler;
    private UserEntityAssembler userEntityAssembler;


    public UserService(UserRepository userRepository, UserDTOAssembler userDTOAssembler, UserEntityAssembler userEntityAssembler) {
        this.userRepository = userRepository;
        this.userDTOAssembler = userDTOAssembler;
        this.userEntityAssembler = userEntityAssembler;
    }

    public UserDTO create(UserDTO userDTO) {
        User user  = userEntityAssembler.toModel(userDTO);
        
        try {
        	Optional<User> userEmailInvaldid = this.userRepository.findByEmail(userDTO.getEmail());
        } catch (Exception e) {
			// TODO: handle exception
		}
        UserDTO userCreateDTO = userDTOAssembler.toModel(this.userRepository.save(user));
        return userCreateDTO;
    }


    public UserDTO showUser(Long id) {
                User user = this.searchOrFailEntity(id);
                UserDTO userDTO = this.userDTOAssembler.toModel(user);
                return userDTO;
    }

    private User searchOrFailEntity(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format(ErrorMessageStatus.MSG_USUARIO_NAO_ENCONTRADO.getDescrition(), id)
                ));
    }
}
