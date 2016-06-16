package com.jorge.springmvc.service;

import java.util.List;

import com.jorge.springmvc.dto.RegisterTomatoDTO;



public interface RegisterTService {
	
	RegisterTomatoDTO findById(long id);
	
	RegisterTomatoDTO findByName(String name);
	
	void saveUser(RegisterTomatoDTO user);
	
	void updateUser(RegisterTomatoDTO user);

	List<RegisterTomatoDTO> findAllUsers(); 
	
	public boolean isUserExist(RegisterTomatoDTO user);
	
}
