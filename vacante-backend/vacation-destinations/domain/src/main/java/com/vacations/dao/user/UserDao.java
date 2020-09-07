package com.vacations.dao.user;

import com.vacations.dao.permission.UserRolesDao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class UserDao {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id_ref")
    private List<UserRolesDao> userRoles = new ArrayList<>();
}
