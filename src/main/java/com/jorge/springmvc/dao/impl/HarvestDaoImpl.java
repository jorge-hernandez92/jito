package com.jorge.springmvc.dao.impl;

import com.jorge.springmvc.dao.AbstractDao;
import com.jorge.springmvc.dao.HarvestDao;
import com.jorge.springmvc.model.Harvest;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository()
public class HarvestDaoImpl extends AbstractDao<Integer, Harvest>
		implements
			HarvestDao {

	@Override
	public void insertHarvest(Harvest harvest) {
		persist(harvest);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Harvest> findAllHarvestByIdUser(Integer idUser) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("idUser", idUser));
		criteria.addOrder(Order.desc("harvestCutDate"));
		return (List<Harvest>) criteria.list();
	}

	@Override
	public void updateHarvest(Harvest harvest) {
		updateHarvest(harvest);
	}

	@Override
	public Harvest findHarvestbyIdHarvest(Integer idHarvest) {
		 Criteria crit = createEntityCriteria();
		    crit.add(Restrictions.eq("idHarvest", idHarvest));
		    return (Harvest) crit.uniqueResult();
	}

	@Override
	public void deleteHarvest(Harvest harvest) {
		delete(harvest);
	}
}
