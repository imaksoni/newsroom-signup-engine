package com.newsroom.signup.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@Entity(name = "user_details")
@Table
public class User {

	@Id
	@Column(name = "user_id")
	private String userID;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "middle_name", nullable = true)
	private String middleName;

	@Column(name = "last_name", nullable = true)
	private String lastName;

	@Column(name = "mail_id", nullable = false)
	private String mailID;

	@Column(name = "mob", nullable = false)
	private String mob;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "dob", nullable = false)
	private String dob;

	@Column(name = "gender", nullable = false)
	private String gender;

}
