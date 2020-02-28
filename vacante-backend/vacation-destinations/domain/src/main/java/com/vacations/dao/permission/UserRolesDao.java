package com.vacations.dao.permission;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vacations.dao.user.UserDao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
@NoArgsConstructor
@Getter
@Setter
public class UserRolesDao {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private UserDao userId;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "role")
	private RoleEnum userRoleEnum;
}
