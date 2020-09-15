package com.vacations.dao.user;

import com.vacations.dao.base.BaseEntity;
import com.vacations.dao.orders.OrderEntity;
import com.vacations.dao.permission.UserRolesEntity;
import com.vacations.dao.user.pojo.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class UserEntity extends BaseEntity {

    @NotNull
    private String email;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    private String gender;

    @NotNull
    private String password;

    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean isAccountNonExpired = true;

    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean isAccountNonLocked = true;

    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean isCredentialsNonExpired = true;

    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean isEnabled = true;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<UserRolesEntity> userRoles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<OrderEntity> orders;

    public User toUser() {
        return User.builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .password(password)
                .isAccountNonExpired(isAccountNonExpired)
                .isAccountNonLocked(isAccountNonLocked)
                .isCredentialsNonExpired(isCredentialsNonExpired)
                .isEnabled(isEnabled)
                .userRoles(userRoles.stream().map(UserRolesEntity::toUserRoles).collect(toList()))
                .orders(orders.stream().map(OrderEntity::toOrder).collect(toList()))
                .build();
    }
}
