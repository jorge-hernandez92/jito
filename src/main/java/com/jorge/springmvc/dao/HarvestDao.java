package com.jorge.springmvc.dao;

import java.util.List;

import com.jorge.springmvc.model.Harvest;

public interface HarvestDao {
  void insertHarvest(Harvest harvest);
  List<Harvest> findAllHarvestByIdUser(Integer idUser);
}
