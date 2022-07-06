package com.loginproject.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.loginproject.login.service.RegisterService;


@Controller
@CrossOrigin("http://127.0.0.1:5500/")
public class RegisterController {
	
	private final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	RegisterService r;

	@PostMapping(path="/validatelogin")
	public ResponseEntity<?> validatelogin(@RequestBody LoginPojo lo) {
	/*	Register r=repo.findById(lo.getUserid()).orElse(null);
			if(r.getPassword().equals(lo.getPass()))
				return new ResponseEntity<>(HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);*/
		logger.info("Validating login credentials");
		ResponseEntity<?> response=r.validatelogin(lo);
		return response;
	}

	@PostMapping(path="/signup")
	public ResponseEntity<?> register(@RequestBody Register reg) {
	/*	Register r=repo.findByEmail(reg.getEmail());
		if(r!=null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		repo.save(reg);
		return new ResponseEntity<>(HttpStatus.OK);*/
		logger.info("Registration for new user");
		logger.warn("Default password get created");
		ResponseEntity<?> response=r.register(reg);
		return response;
	}

	@PostMapping(path="/updatepass",consumes="application/json")
	public ResponseEntity<?> updatepass(@RequestBody UpdatePassword Up) {
	/*	Register r=repo.findById(Up.getUserid()).orElse(null);
		
		if(r.getId().equals(Up.getUserid()) && r.getPassword().equals(Up.getOldpass())) {
			if(Up.getNewpass().equals(Up.getConfirmpass())) {
				r.setPassword(Up.getNewpass());
				repo.save(r);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);*/
		logger.info("Updating password");
		ResponseEntity<?> response=r.updatepass(Up);
		return response;
	}
		


	@PostMapping(path="/forgetpass",consumes="application/json")
	public ResponseEntity<?> forget(@RequestBody ForgetPassword fp) {
	/*	Register r=repo.findById(fp.getUserid()).orElse(null);
	
		if(r.getId().equals(fp.getUserid()) && r.getDob().equals(fp.getDob())) {
			if(fp.getNewpass().equals(fp.getConfirmpass())) {
				r.setPassword(fp.getNewpass());
				repo.save(r);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);*/
		logger.info("Updating password");
		ResponseEntity<?> response=r.forget(fp);
		return response;
	}



/*@GetMapping("/changepassword")
public String changepass() {
System.out.println("Hello");
return "changepassword";
}
@PostMapping("/changepass")
//@ResponseBody
public String updatepass(@RequestParam String email,@RequestParam String dob ,@RequestParam String oldpass,@RequestParam String newpass,@RequestParam String confirmpass) {
//System.out.println(email);
//System.out.println("Hello");

List<Register> list=new ArrayList<Register>();
repo.findAll().forEach(list::add);
for(int i=0;i<list.size();i++) {
//System.out.println("Hii");

Register r=list.get(i);
//System.out.println(r);

if(r.getEmail().equals(email) && r.getPassword().equals(oldpass)) {
if(newpass.equals(confirmpass)) {
r.setPassword(newpass);
//System.out.println(r.getPassword());
repo.save(r);
return "redirect:/loginpage";
}
}
}

return "redirect:/";
}

@GetMapping("/forgetpass")
public String forgetpass() {
return "forgetPassword";
}


/*@GetMapping("/getUser")
public List<Student> getStudents(){
List<Student> list=new ArrayList<Student>();
repo.findAll().forEach(list::add);
System.out.println(list);
return list;
}

@GetMapping("/getStudents/{sid}")
public Optional<Student> getEachStudent(@PathVariable("sid") int id) {
return repo.findById(id);
}


@PutMapping("/updateStudents/{sid}")
public String updateStudents(@RequestBody Student s, @PathVariable("sid") int id) {
List<Student> list=new ArrayList<Student>();
repo.findAll().forEach(list::add);
System.out.println(list);
for(int i=0; i<list.size();i++) {

Student s1=list.get(i);
if(s1.getSid()==id) {
repo.save(s);
return "Row Updated";
}
}
return "invalid sid";
}

@DeleteMapping("/deleteStudents/{sid}")
public String deleteStudent(@PathVariable("sid") int id) {
repo.deleteById(id);
return "Row_Deleted";
}

@DeleteMapping("/deleteAllStudents")
public String deleteAllStudent() {
repo.deleteAll();
return "All_Rows_Deleted";
}*/



}