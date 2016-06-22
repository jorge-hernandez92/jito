package com.jorge.springmvc.service;

import java.util.List;

import com.jorge.springmvc.dto.RegisterTomatoDTO;



public interface RegisterTService {
	
	void saveUser(RegisterTomatoDTO user, Integer idUser);

	List<RegisterTomatoDTO> findAllUsers(); 
	
}
