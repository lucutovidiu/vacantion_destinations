package com.proiect.vacationdestinations.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.proiect.vacationdestinations.model.Role;
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
	private Role userRole;
}
