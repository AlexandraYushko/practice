package org.example.adapter.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserResponse {
    private String uuid;
    private String email;
    private String name;
}
