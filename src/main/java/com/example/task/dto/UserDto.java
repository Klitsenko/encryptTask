package com.example.task.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.validation.constraints.NotNull;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class UserDto {
    private Long id;
    @NotNull
    private String name;

    public UserDto() {
    }

    public UserDto(Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
