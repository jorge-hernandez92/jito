package com.jorge.springmvc.dao;

import java.util.List;

import com.jorge.springmvc.model.Harvest;

public interface HarvestDao {
  void insertHarvest(Harvest harvest);
  List<Harvest> findAllHarvestByIdUser(Integer idUser);
  void updateHarvest(Harvest harvest);
  Harvest findHarvestbyIdHarvest(Integer idHarvest);
}
