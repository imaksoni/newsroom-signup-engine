package com.newsroom.signup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.newsroom.signup.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	@Modifying
	@Transactional
	@Query(value = "insert into user_details(user_id,first_name,middle_name,last_name,mail_id,mob,password,dob,gender) values (:userID,:firstName,:middleName,:lastName,:mailID,:mob,:password,:dob,:gender)", nativeQuery = true)
	int saveDetails(@Param("userID") String userID, @Param("firstName") String firstName,
			@Param("middleName") String middleName, @Param("lastName") String lastName, @Param("mailID") String mailID,
			@Param("mob") String mob, @Param("password") String password, @Param("dob") String dob,
			@Param("gender") String gender);

	@Modifying
	@Transactional
	@Query(value = "insert into login_user_details(user_id,mail_id,mob_no,password) values (:userID,:mailID,:mob,:password)", nativeQuery = true)
	int saveLoginDetails(@Param("userID") String userID, @Param("mailID") String mailID, @Param("mob") String mob,
			@Param("password") String password);

}
