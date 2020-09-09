package com.vacations.dao.permission;

import com.vacations.dao.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
@NoArgsConstructor
@Getter
@Setter
public class UserRolesEntity extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private RoleEnum userRoleEnum;
}
