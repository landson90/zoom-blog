package com.escola.zoomapp.service;

import com.escola.zoomapp.dto.UserDTO;
import com.escola.zoomapp.mapper.UserDTOAssembler;
import com.escola.zoomapp.mapper.UserEntityAssembler;
import com.escola.zoomapp.model.User;
import com.escola.zoomapp.repository.UserRepository;
import org.springframework.stereotype.Service;

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
        UserDTO userCreateDTO = userDTOAssembler.toModel(this.userRepository.save(user));
        return userCreateDTO;
    }


}
