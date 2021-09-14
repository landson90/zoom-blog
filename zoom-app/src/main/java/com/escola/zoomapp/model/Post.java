package com.escola.zoomapp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "tb_poster")
public class Post {

    private Long id;
    private String description;
    private String title;
    private String content;
}
