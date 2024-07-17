package com.oss.nur.entity;

import com.oss.nur.config.base.BaseEntityUUID;
import com.oss.nur.entity.enums.Gender;
import com.oss.nur.entity.enums.Role;
import com.oss.nur.entity.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Table(name = "auth_user")
public class User extends BaseEntityUUID {

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)

    private Role role;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_status", nullable = false)
    private Status status;


}
