package com.example.demo.systemuser.controller.dto;

import com.example.demo.systemuser.SystemUser;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDetailDTO implements Serializable {

    private String username;
    private String mail;

    public UserDetailDTO(SystemUser user) {
        this.username = user.getUsername();
        this.mail = user.getMail();
    }
}
