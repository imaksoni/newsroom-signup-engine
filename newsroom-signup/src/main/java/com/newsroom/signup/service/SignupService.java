package com.newsroom.signup.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsroom.signup.entity.User;
import com.newsroom.signup.model.Data;
import com.newsroom.signup.model.SignupRequest;
import com.newsroom.signup.model.SignupResponse;
import com.newsroom.signup.repo.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SignupService {

	@Autowired
	private UserRepo userRepo;

	public SignupResponse signup(SignupRequest request) {

		SignupResponse resp = SignupResponse.builder().success(false).data(Data.builder().userID("").build()).build();

		try {

			String userID = getUserID();

			User user = User.builder().userID(userID).firstName(request.getFirstName())
					.middleName(request.getMiddleName()).lastName(request.getLastName()).mailID(request.getMailID())
					.mob(request.getMob()).password(request.getPassword()).dob(request.getDob())
					.gender(request.getGender()).build();

			int status = 0;

			synchronized (request) {

				status = userRepo.saveDetails(user.getUserID(), user.getFirstName(), user.getMiddleName(),
						user.getLastName(), user.getMailID(), user.getMob(), user.getPassword(), user.getDob(),
						user.getGender());

				if (status != 0) {
					status = userRepo.saveLoginDetails(user.getUserID(), user.getMailID(), user.getMob(),
							user.getPassword());
				}

				else {
					log.info("Engine: Signup Failed while saving Details!!!- {}", request);
				}

			}

			if (status != 0) {
				log.info("Engine: Signup Successfull!!!-{}", request);
				resp.setSuccess(true);
				resp.getData().setUserID(userID);
			}

			else {
				log.info("Engine: Signup Failed while saving Details!!!-{}", request);
			}

		}

		catch (Exception ex) {
			log.info("Engine: Oops.. Seems some runtime issues - {}", ex.getLocalizedMessage());
			log.info("Engine: Oops.. Seems some runtime issues - {}", request);
		}

		return resp;

	}

	public String getUserID() {

		return "newsroom-" + UUID.randomUUID();

	}

}
