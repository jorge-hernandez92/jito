package com.jorge.springmvc.dao.impl;

import com.jorge.springmvc.dao.AbstractDao;
import com.jorge.springmvc.dao.HarvestDao;
import com.jorge.springmvc.model.Harvest;

import org.springframework.stereotype.Repository;

@Repository()
public class HarvestDaoImpl extends AbstractDao<Integer, Harvest> implements HarvestDao {

  @Override
  public void insertHarvest(Harvest harvest) {
    persist(harvest);
  }

}
