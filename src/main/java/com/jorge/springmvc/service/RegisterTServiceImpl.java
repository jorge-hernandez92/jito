package com.jorge.springmvc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jorge.springmvc.dao.ProduccionDAO;
import com.jorge.springmvc.dao.UserDAO;
import com.jorge.springmvc.dto.RegisterTomatoDTO;
import com.jorge.springmvc.model.Produccion;
import com.jorge.springmvc.model.TipoDeCultivo;
import com.jorge.springmvc.model.Usuario;

@Service("registerTService")
@Transactional
public class RegisterTServiceImpl implements RegisterTService{
	
	@Autowired
	ProduccionDAO productionDAO;  
	
	@Autowired
	UserDAO usuarioDAO;
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<RegisterTomatoDTO> users = new ArrayList<RegisterTomatoDTO>();
	
	public List<RegisterTomatoDTO> findAllUsers() {
		
		List<Produccion> listProduc = productionDAO.getAllProduccion();
		List<RegisterTomatoDTO> listRP = new ArrayList<RegisterTomatoDTO>();
		
		for (Produccion produccion : listProduc) {
			RegisterTomatoDTO rp = new RegisterTomatoDTO();
			rp.setCantidad(produccion.getCantidad());
			rp.setDate(produccion.getFechaCorte());
			rp.setUsername(produccion.getUsuario().getNombre());
			listRP.add(rp);
		}
		
		return listRP;
	}
	
	public RegisterTomatoDTO findById(long id) {
		/*
		for(RegisterTomatoDTO user : users){
			if(user.getId() == id){
				return user;
			}
		}*/
		System.out.println("aqui se busca que exista usuario");
		return null;
	}
	
	public RegisterTomatoDTO findByName(String name) {
		for(RegisterTomatoDTO user : users){
			if(user.getUsername().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(RegisterTomatoDTO user) {
		
		Usuario usuario = usuarioDAO.getUserByLoginAndPassword(user.getUsername(), user.getPassword());
		
		if(usuario != null){
			Produccion produccion = new Produccion();
			produccion.setCantidad(user.getCantidad());
			produccion.setFechaRegistro(new Date());
			produccion.setFechaCorte(user.getDate());
			
			TipoDeCultivo tdc = new TipoDeCultivo();
			tdc.setIdTipoDeCultivo(1);
			
			Usuario u = new Usuario();
			u.setIdUsuario(1);
			
			produccion.setTipoDeCultivo(tdc);
			produccion.setUsuario(u);
			
			productionDAO.save(produccion);
		}
		else{
			System.out.println("no esxiste ese usuario");
		}
	
	}

	public void updateUser(RegisterTomatoDTO user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<RegisterTomatoDTO> iterator = users.iterator(); iterator.hasNext(); ) {
		    RegisterTomatoDTO user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(RegisterTomatoDTO user) {
		return findByName(user.getUsername())!=null;
	}


}
