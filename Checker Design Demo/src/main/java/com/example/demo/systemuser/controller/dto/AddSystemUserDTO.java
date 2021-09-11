package com.example.demo.systemuser.controller.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddSystemUserDTO implements Serializable {

    private String username;
    private String password;
    private String mail;

}
