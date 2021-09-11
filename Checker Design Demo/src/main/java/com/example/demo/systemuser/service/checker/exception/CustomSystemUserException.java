package com.example.demo.systemuser.service.checker.exception;

import com.example.demo.systemuser.SystemUser;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomSystemUserException extends RuntimeException {

    private final SystemUser systemUser;

    public CustomSystemUserException(SystemUser systemUser, String errorMessage) {
        super(errorMessage);
        this.systemUser = systemUser;
    }

}
