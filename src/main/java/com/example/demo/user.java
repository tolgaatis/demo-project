package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class user {
 private Long iduser;
 private String username;
 private String password;

         protected user() {
        	 super();
         }

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
         public Long getIduser() {
			return iduser;
		}

		public void setIduser(Long iduser) {
			this.iduser = iduser;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		
         
}