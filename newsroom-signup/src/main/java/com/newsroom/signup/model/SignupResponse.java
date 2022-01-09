package com.newsroom.signup.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class SignupResponse {

	private boolean success;

	private Data data;

}
