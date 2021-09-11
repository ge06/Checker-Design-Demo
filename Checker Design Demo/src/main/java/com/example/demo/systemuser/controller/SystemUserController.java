package com.example.demo.systemuser.controller;

import com.example.demo.systemuser.SystemUser;
import com.example.demo.systemuser.controller.dto.AddSystemUserDTO;
import com.example.demo.systemuser.controller.dto.UserDetailDTO;
import com.example.demo.systemuser.service.SystemUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SystemUserController {

    private final SystemUserService systemUserService;

    @GetMapping
    public ResponseEntity<List<UserDetailDTO>> getAll() {
        return ResponseEntity.ok(
                systemUserService.getAll().stream().map(UserDetailDTO::new).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody AddSystemUserDTO addDTO) {
        Long id = systemUserService.add(new SystemUser(addDTO));
        return ResponseEntity.ok("System user created! ID: " + id);
    }
}
