package com.aljaffarsyah.webkes.login.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.aljaffarsyah.webkes.login.model.User;
import com.aljaffarsyah.webkes.login.web.dto.UserRegistrationDto;


public interface UserService extends UserDetailsService {

	User save(UserRegistrationDto registrationDto);
}
