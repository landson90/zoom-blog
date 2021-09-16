package com.escola.zoomapp.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@Getter
@Builder
public class Problem {

    private Integer status;
    private String type;
    private String title;
    private String detail;
    private List<Field> fields;

    @Getter
    @Builder
    public static class Field {
        private String fieldName;
        private String fielMessage;
    }

}
