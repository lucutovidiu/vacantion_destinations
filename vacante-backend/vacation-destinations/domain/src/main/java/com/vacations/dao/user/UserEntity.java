package com.vacations.dao.user;

import com.vacations.dao.base.BaseEntity;
import com.vacations.dao.orders.OrderEntity;
import com.vacations.dao.permission.UserRolesEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Cache;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
}
