package org.example.adapter.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {
    private String uuid;
    private String email;
    private String name;
}
