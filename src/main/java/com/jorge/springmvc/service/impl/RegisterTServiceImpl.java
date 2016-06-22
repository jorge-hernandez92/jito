package com.jorge.springmvc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jorge.springmvc.dao.ProduccionDAO;
import com.jorge.springmvc.dao.UserDAO;
import com.jorge.springmvc.dto.RegisterTomatoDTO;
import com.jorge.springmvc.model.Produccion;
import com.jorge.springmvc.model.TipoDeCultivo;
import com.jorge.springmvc.model.Usuario;
import com.jorge.springmvc.service.RegisterTService;

@Service("registerTService")
@Transactional
public class RegisterTServiceImpl implements RegisterTService{
	
	@Autowired
	ProduccionDAO productionDAO;  
	
	@Autowired
	UserDAO usuarioDAO;
	
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
	
	
	public void saveUser(RegisterTomatoDTO user, Integer idUser) {
		
			Produccion produccion = new Produccion();
			produccion.setCantidad(user.getCantidad());
			produccion.setFechaRegistro(new Date());
			produccion.setFechaCorte(user.getDate());
			
			TipoDeCultivo tdc = new TipoDeCultivo();
			tdc.setIdTipoDeCultivo(1);
			
			Usuario u = new Usuario();
			u.setIdUsuario(idUser);
			
			produccion.setTipoDeCultivo(tdc);
			produccion.setUsuario(u);
			
			productionDAO.save(produccion);
	
	}


}
