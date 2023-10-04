package com.example.dbPolitech.dto;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class UserDto {
    @NotNull
    private String name;
    @NotNull
    private String password;
}
