package com.escola.zoomapp.dto;

import com.escola.zoomapp.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    @EqualsAndHashCode.Include
    private Long id;
    private String description;
    private String title;
    private String content;
    private UserEntity user;
}
