package com.health.notification.controller;

import com.health.notification.dto.SigninRequest;
import com.health.notification.dto.SigninResponse;
import com.health.notification.dto.SignupRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AuthController {

    @PostMapping("/signin")
    public ResponseEntity<SigninResponse> signIn(@RequestBody SigninRequest signinRequest) {
        try {
            SigninResponse signinResponse = new SigninResponse();
            signinResponse.setToken("token");
            signinResponse.setUser("user");
            return new ResponseEntity<>(signinResponse, HttpStatus.OK);
        } catch (Exception e) {
            SigninResponse signinResponse = new SigninResponse();
            signinResponse.setToken("error");
            signinResponse.setUser("error");
            return new ResponseEntity<>(signinResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignupRequest signupRequest) {
        try {
            return ResponseEntity.ok("Signup successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Signup failed: " + e.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {
        try {
            return ResponseEntity.ok("Logout successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Signup failed: " + e.getMessage());
        }
    }
}
