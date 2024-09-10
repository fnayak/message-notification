package com.health.notification.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SigninRequest {

    private String email;
    private String password;
}