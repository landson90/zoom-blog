package com.escola.zoomapp.mapper;

import com.escola.zoomapp.dto.UserDTO;
import com.escola.zoomapp.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserEntityAssembler {

    @Autowired
    public ModelMapper modelMapper;

    public User toModel(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

}
