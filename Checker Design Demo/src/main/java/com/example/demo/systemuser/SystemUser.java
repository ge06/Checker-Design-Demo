package com.example.demo.systemuser;

import com.example.demo.infrastructure.entity.AbstractEntity;
import com.example.demo.systemuser.controller.dto.AddSystemUserDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@Table(name = "SYSTEM_USER")
public class SystemUser extends AbstractEntity {

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String mail;

    public SystemUser(AddSystemUserDTO addDTO) {
        this.username = addDTO.getUsername();
        this.password = addDTO.getPassword();
        this.mail = addDTO.getMail();
    }

}
