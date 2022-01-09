package com.newsroom.signup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

	private String firstName;

	private String middleName;

	private String lastName;

	private String mailID;

	private String mob;

	private String password;

	private String dob;

	private String gender;

}
