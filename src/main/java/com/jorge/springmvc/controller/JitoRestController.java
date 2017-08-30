package com.jorge.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.springmvc.dto.HarvestDto;
import com.jorge.springmvc.model.Harvest;
import com.jorge.springmvc.model.User;
import com.jorge.springmvc.service.HarvestService;
import com.jorge.springmvc.service.UserService;

@RestController
public class JitoRestController {

	@Autowired
	UserService userService;

	@Autowired
	HarvestService harvestService;

	private static final Logger logger = LogManager
			.getLogger(JitoRestController.class);

	/**
	 * Insert new Harvest into data base
	 * 
	 * @param session
	 * @param harvestDto
	 * @return
	 */
	@RequestMapping(value = "/addProduction", method = RequestMethod.POST)
	public ResponseEntity<Void> addProduction(HttpSession session,
			@RequestBody HarvestDto harvestDto) {
		User userLogin = (User) session.getAttribute("USER");
		if (userLogin != null) {
			Harvest harvest = new Harvest();
			harvest.setIdHarvest(harvestDto.getIdHarvest());
			harvest.setComments(harvestDto.getComments());
			harvest.setHarvestCutDate(harvestDto.getDate());
			harvest.setTotalPrice(harvestDto.getPrice());
			harvest.setRegistrationDate(new Date());
			harvest.setWeight(harvestDto.getWeight());
			harvest.setUser(userLogin);
			harvest.setIdHarvest(harvestDto.getIdHarvest());
			if(harvest.getIdHarvest() == null) {
				harvestService.insertHarvest(harvest);	
			}else {
				harvestService.updateHarvest(harvest);
			}
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(value = "/allProduction/", method = RequestMethod.GET)
	public ResponseEntity<List<HarvestDto>> listAllHarvest(HttpSession session) {
		User userLogin = (User) session.getAttribute("USER");
		List<Harvest> listHarvest = harvestService
				.findAllHarvestByIdUser(userLogin.getIdUser());
		List<HarvestDto> listHarvestDto = new ArrayList<HarvestDto>();
		for (Harvest harvest : listHarvest) {
			HarvestDto harvestDto = new HarvestDto();
			harvestDto.setIdHarvest(harvest.getIdHarvest());
			harvestDto.setComments(harvest.getComments());
			harvestDto.setPrice(harvest.getTotalPrice());
			harvestDto.setWeight(harvest.getWeight());
			harvestDto.setDate(harvest.getHarvestCutDate());
			listHarvestDto.add(harvestDto);
		}
		if (listHarvest.isEmpty()) {
			return new ResponseEntity<List<HarvestDto>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<HarvestDto>>(listHarvestDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/harvest/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Harvest> deleteUser(@PathVariable("id") int idHarvest) {
		logger.error("deleting harvest: "+idHarvest);
		Harvest harvest = harvestService.findHarvestbyIdHarvest(idHarvest);
		if(harvest != null) {
			harvestService.deleteHarvest(harvest);
		} else {
			return new ResponseEntity<Harvest>(HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<Harvest>(HttpStatus.NO_CONTENT);
    }

}
