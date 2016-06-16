package com.jorge.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.jorge.springmvc.dao.AbstractDAO;
import com.jorge.springmvc.dao.ProduccionDAO;
import com.jorge.springmvc.model.Produccion;

@Repository("productionDAO")
public class ProduccionDAOImpl extends AbstractDAO<Integer, Produccion> implements ProduccionDAO {

	@Override
	public void save(Produccion produccion) {
		persist(produccion);
	}

	@Override
	public List<Produccion> getAllProduccion() {
		Criteria criteria = createEntityCriteria();
		List<Produccion> listPro = (List<Produccion>) criteria.list(); 
		return listPro;
	}

}
