package com.example.demo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@Transactional
public class UserService {
	
	 
    @Autowired
	private UserRepository repo;
	private String username;
	private String password;
	     
	    public List<user> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(user user) {
	        repo.save(user);
	    }
	     
	    public user get(long iduser) {
	        return repo.findById(iduser).get();
	    }
	     
	    public void delete(long iduser) {
	        repo.deleteById(iduser);
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }
	    
	    public String getUsername(String username) {
	        return username;
	    }
	    
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    
	    public String getPassword(String password) {
	        return password;
	    }

		
	    
	   
	    


	   
	}

