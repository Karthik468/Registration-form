package com.loginproject.login;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loginproject.login.service.RegisterService;

@RunWith(JUnitPlatform.class)
@WebMvcTest(RegisterController.class)
class LoginApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(LoginApplicationTests.class);
	
	@Autowired
	private MockMvc mvc;



	@MockBean
	RegisterService rs;



	public static String asJsonString(final Object obj) throws JsonProcessingException{
	return new ObjectMapper().writeValueAsString(obj);
	}
	
	@Test
	void Create() throws Exception {
	Register r=new Register();
	r.setId("2s");
	r.setFname("Virat Kohli");
	r.setLname("T");
	r.setDob("11-11-1987");
	r.setEmail("virat@gmail.com");
	r.setPhone("98XXXXXXX");
	r.setPassword("Vamika");
	logger.info("Create method was testing");
	Mockito.when(rs.register(r)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
	URI uri = new URI("/signup");
	mvc.perform(MockMvcRequestBuilders.post(uri)
	.content(asJsonString(r))
	.contentType(MediaType.APPLICATION_JSON)
	.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	void LoginCreate() throws Exception {
		LoginPojo l=new LoginPojo();
		l.setUserid("kk");
		l.setPass("virat");
		logger.info("LoginCreate method was testing");
	Mockito.when(rs.validatelogin(l)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
	URI uri = new URI("/validatelogin");
	mvc.perform(MockMvcRequestBuilders.post(uri)
	.content(asJsonString(l))
	.contentType(MediaType.APPLICATION_JSON)
	.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	void UpdateCreate() throws Exception {
		UpdatePassword u=new UpdatePassword();
		u.setUserid("1ss");
		u.setOldpass("virat");
		u.setNewpass("ss");
		u.setConfirmpass("ss");
		logger.info("UpdatePasswordCreate method was testing");
	Mockito.when(rs.updatepass(u)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
	URI uri = new URI("/updatepass");
	mvc.perform(MockMvcRequestBuilders.post(uri)
	.content(asJsonString(u))
	.contentType(MediaType.APPLICATION_JSON)
	.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	void ForgetCreate() throws Exception {
		ForgetPassword f=new ForgetPassword();
		f.setUserid("1ss");
		f.setDob("24-11-2000");
		f.setNewpass("ss");
		f.setConfirmpass("ss");
		logger.info("ForgetPasswordCreate method was testing");
	Mockito.when(rs.forget(f)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
	URI uri = new URI("/forgetpass");
	mvc.perform(MockMvcRequestBuilders.post(uri)
	.content(asJsonString(f))
	.contentType(MediaType.APPLICATION_JSON)
	.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	

}
