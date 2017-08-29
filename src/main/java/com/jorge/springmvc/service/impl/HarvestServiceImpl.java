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

}
