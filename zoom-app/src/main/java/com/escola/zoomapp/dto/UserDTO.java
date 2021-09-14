package com.escola.zoomapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String email;
    private String password;
}
