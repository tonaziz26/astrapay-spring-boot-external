package com.astrapay.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ExampleDto {
    @NotEmpty(message = "name is required")
    private String name;
    
    @NotEmpty(message = "description is required")
    private String description;
}