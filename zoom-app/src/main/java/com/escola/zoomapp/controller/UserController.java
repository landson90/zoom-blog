package com.escola.zoomapp.controller;

import com.escola.zoomapp.dto.UserDTO;
import com.escola.zoomapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/usuarios")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<UserDTO> store(@RequestBody @Valid UserDTO userDTO) {
        UserDTO user = this.userService.create(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @GetMapping("/{id}")
   public ResponseEntity<UserDTO> show(@PathVariable Long id) {
        UserDTO userDTO = this.userService.showUser(id);
        return ResponseEntity.ok().body(userDTO);

   }

}
