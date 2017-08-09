package com.jorge.springmvc.service.impl;

import com.jorge.springmvc.dao.HarvestDao;
import com.jorge.springmvc.model.Harvest;
import com.jorge.springmvc.service.HarvestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HarvestServiceImpl implements HarvestService {
  
  @Autowired
  HarvestDao harvestDao;
  
  @Override
  public void insertHarvest(Harvest harvest) {
    harvestDao.insertHarvest(harvest);
  }

}
