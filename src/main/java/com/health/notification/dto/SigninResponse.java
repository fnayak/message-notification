package com.health.notification.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SigninResponse {

    private String token;
    private String user;
}