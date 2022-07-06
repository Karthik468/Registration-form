package com.loginproject.login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RegisterDao extends JpaRepository<Register,String>{

	Register findByEmail(String email);


}