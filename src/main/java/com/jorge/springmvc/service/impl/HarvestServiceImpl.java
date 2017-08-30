package com.jorge.springmvc.service.impl;

import com.jorge.springmvc.dao.HarvestDao;
import com.jorge.springmvc.model.Harvest;
import com.jorge.springmvc.service.HarvestService;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HarvestServiceImpl implements HarvestService {

	@Autowired
	HarvestDao harvestDao;

	@Override
	public void insertHarvest(Harvest harvest) {
		harvestDao.insertHarvest(harvest);
	}

	@Override
	public List<Harvest> findAllHarvestByIdUser(Integer idUser) {
		return harvestDao.findAllHarvestByIdUser(idUser);
	}

	/*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
	@Override
	public void updateHarvest(Harvest harvest) {
		Harvest harvestUpdated = harvestDao.findHarvestbyIdHarvest(harvest.getIdHarvest());
		harvestUpdated.setComments(harvest.getComments());
		harvestUpdated.setHarvestCutDate(harvest.getHarvestCutDate());
		harvestUpdated.setTotalPrice(harvest.getTotalPrice());
		harvestUpdated.setRegistrationDate(harvest.getRegistrationDate());
		harvestUpdated.setWeight(harvest.getWeight());
	}

	@Override
	public void deleteHarvest(Harvest harvest) {
		harvestDao.deleteHarvest(harvest);
	}

	@Override
	public Harvest findHarvestbyIdHarvest(Integer idHarvest) {
		return harvestDao.findHarvestbyIdHarvest(idHarvest);
	}

}
