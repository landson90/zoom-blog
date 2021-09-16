package com.escola.zoomapp.service;

import com.escola.zoomapp.dto.UserDTO;
import com.escola.zoomapp.exception.user.UserNotFoundException;
import com.escola.zoomapp.mapper.user.UserDTOAssembler;
import com.escola.zoomapp.mapper.user.UserEntityAssembler;
import com.escola.zoomapp.model.User;
import com.escola.zoomapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final String MSG_USUÁRIO_EM_USO
            = "Usuário de código %d não encontrado.";

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


    public UserDTO showUser(Long id) {
                User user = this.searchOrFailEntity(id);
                UserDTO userDTO = this.userDTOAssembler.toModel(user);
                return userDTO;
    }

    private User searchOrFailEntity(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format(MSG_USUÁRIO_EM_USO, id)
                ));
    }
}
