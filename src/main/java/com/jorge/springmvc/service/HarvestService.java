package com.jorge.springmvc.service;

import java.util.List;

import com.jorge.springmvc.dto.HarvestDto;
import com.jorge.springmvc.model.Harvest;

public interface HarvestService {
  void insertHarvest(Harvest harvest);
  List<Harvest> findAllHarvestByIdUser(Integer idUser);	
  void updateHarvest(Harvest harvest);
}
