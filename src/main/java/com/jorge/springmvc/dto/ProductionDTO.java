package com.jorge.springmvc.dto;

import java.util.Date;

public class ProductionDTO {
	private String username;
	
	private Integer cantidad; 
	
	private Date date;
	
	public ProductionDTO(){
		
	}
	
	public ProductionDTO(Integer cantidad, Date date){
		
		this.cantidad = cantidad;
		this.date = date;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}


