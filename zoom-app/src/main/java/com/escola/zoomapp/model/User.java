package com.escola.zoomapp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "tb_usuario")
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    
}
