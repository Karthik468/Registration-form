package com.loginproject.login.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.loginproject.login.ForgetPassword;
import com.loginproject.login.LoginPojo;
import com.loginproject.login.Register;
import com.loginproject.login.RegisterDao;
import com.loginproject.login.UpdatePassword;

@Service
public class RegisterService {
	
	private final Logger logger = LoggerFactory.getLogger(RegisterService.class);
	@Autowired
	RegisterDao repo;

	
	public ResponseEntity<?> validatelogin(LoginPojo lo) {
		Register r=repo.findById(lo.getUserid()).orElse(null);
			if(r.getPassword().equals(lo.getPass())) {
				logger.info("Password matched.You are onboard");
				return new ResponseEntity<>(HttpStatus.OK);
			}
		logger.info("Password not matched.");
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}

	
	public ResponseEntity<?> register( Register reg) {
		Register r=repo.findByEmail(reg.getEmail());
		if(r!=null) {
			logger.error("User already exists");
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		repo.save(reg);
		logger.info("Sucessfully created new user");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	public ResponseEntity<?> updatepass( UpdatePassword Up) {
		Register r=repo.findById(Up.getUserid()).orElse(null);
		
		if(r.getId().equals(Up.getUserid()) && r.getPassword().equals(Up.getOldpass())) {
			if(Up.getNewpass().equals(Up.getConfirmpass())) {
				r.setPassword(Up.getNewpass());
				logger.info("Password Updated sucessfully");
				repo.save(r);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		logger.error("New password doesn't match old password");
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
		


	
	public ResponseEntity<?> forget( ForgetPassword fp) {
		Register r=repo.findById(fp.getUserid()).orElse(null);
	
		if(r.getId().equals(fp.getUserid()) && r.getDob().equals(fp.getDob())) {
			if(fp.getNewpass().equals(fp.getConfirmpass())) {
				r.setPassword(fp.getNewpass());
				repo.save(r);
				logger.info("Password Updated sucessfully");
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		logger.error("New password doesn't match confirm password");
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}


}
