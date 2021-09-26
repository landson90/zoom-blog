package com.escola.zoomapp.mapper.user;

import com.escola.zoomapp.dto.UserDTO;
import com.escola.zoomapp.model.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserEntityAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public UserEntity toModel(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }

}
