package com.example.demo.systemuser.service.checker;

import com.example.demo.infrastructure.specification.AbstractSpecification;
import com.example.demo.infrastructure.specification.SpecificationName;
import com.example.demo.systemuser.SystemUser;
import com.example.demo.systemuser.service.checker.exception.CustomSystemUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckUserForSaveSpec extends AbstractSpecification<SystemUser> {

    private final CheckUserUsernameSpec checkUserUsernameSpec;
    private final CheckUserMailSpec checkUserMailSpec;

    @Override
    public boolean isSatisfiedBy(SystemUser user) throws CustomSystemUserException {
        return checkUserUsernameSpec.and(checkUserMailSpec).isSatisfiedBy(user);
    }

    @Override
    public SpecificationName getName() {
        return SpecificationName.CHECK_USER_FOR_SAVE;
    }
}
