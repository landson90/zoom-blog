package com.escola.zoomapp.mapper;

import com.escola.zoomapp.dto.UserDTO;
import com.escola.zoomapp.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDTOAssembler {

    @Autowired
    public ModelMapper modelMapper;


    public UserDTO toModel(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> toCollectionModel(List<User> userList) {
        return userList.stream().map(u -> toModel(u)).collect(Collectors.toList());
    }
}
