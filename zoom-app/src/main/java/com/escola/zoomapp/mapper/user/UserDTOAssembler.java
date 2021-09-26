package com.escola.zoomapp.mapper.user;

import com.escola.zoomapp.dto.UserDTO;
import com.escola.zoomapp.model.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDTOAssembler {

    @Autowired
    private ModelMapper modelMapper;


    public UserDTO toModel(UserEntity user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> toCollectionModel(List<UserEntity> userList) {
        return userList.stream().map(u -> toModel(u)).collect(Collectors.toList());
    }
}
