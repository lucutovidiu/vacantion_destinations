package com.vacations.dao.user.pojo;

import com.vacations.dao.orders.pojo.Order;
import com.vacations.dao.permission.pojo.UserRoles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@NoArgsConstructor
@Getter
public class User {

    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String password;
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialsNonExpired;
    private Boolean isEnabled;
    private List<UserRoles> userRoles;
    private List<Order> orders;
}
