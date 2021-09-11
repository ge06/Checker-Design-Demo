package com.example.demo.systemuser.service;

import com.example.demo.infrastructure.CheckerFactory;
import com.example.demo.infrastructure.specification.SpecificationName;
import com.example.demo.systemuser.SystemUser;
import com.example.demo.systemuser.SystemUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SystemUserService {

    private final SystemUserRepository systemUserRepository;
    private final CheckerFactory<SystemUser> checkerFactory;

    public List<SystemUser> getAll() {
        return systemUserRepository.findAll();
    }

    public Long add(SystemUser user) {
        if (checkerFactory.execute(SpecificationName.CHECK_USER_FOR_SAVE, user)) {
            systemUserRepository.save(user);
            return user.getId();
        }
        throw new UnsupportedOperationException("error");
    }
}
