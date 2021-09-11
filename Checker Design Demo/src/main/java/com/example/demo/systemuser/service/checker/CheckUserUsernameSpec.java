package com.example.demo.systemuser.service.checker;

import com.example.demo.infrastructure.specification.AbstractSpecification;
import com.example.demo.infrastructure.specification.SpecificationName;
import com.example.demo.systemuser.SystemUser;
import com.example.demo.systemuser.SystemUserRepository;
import com.example.demo.systemuser.service.checker.exception.CustomSystemUserException;
import com.example.demo.systemuser.service.checker.message.SystemUserErrorMessages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class CheckUserUsernameSpec extends AbstractSpecification<SystemUser> {

    private final SystemUserRepository systemUserRepository;

    @Override
    public boolean isSatisfiedBy(SystemUser user) throws CustomSystemUserException {
        Optional<SystemUser> userFromDb = systemUserRepository.findByUsername(user.getUsername());
        if (userFromDb.isPresent()) {
            log.error("username exists!");
            throw new CustomSystemUserException(user, SystemUserErrorMessages.SYSTEM_USER_USERNAME_IS_NOT_UNIQUE);
        }
        return true;
    }

    @Override
    public SpecificationName getName() {
        return SpecificationName.CHECK_USER_USERNAME;
    }
}
