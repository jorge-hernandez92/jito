package com.jorge.springmvc.dto;

import java.util.Date;

import com.jorge.springmvc.dto.RegisterTomatoDTO;

public class RegisterTomatoDTO {
	
	private long id;
	
	private String username;
	
	private Integer cantidad;
	
	private String password; 
	
	private Date date;
	
	public RegisterTomatoDTO(){
		id=0;
	}
	
	public RegisterTomatoDTO(long id, String username, Integer cantidad, Date date){
		this.id = id;
		this.username = username;
		this.cantidad = cantidad;
		this.date = date; 
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RegisterTomatoDTO))
			return false;
		RegisterTomatoDTO other = (RegisterTomatoDTO) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RegisterTomatoDTO [id=" + id + ", username=" + username + ", cantidad=" + cantidad + ", password="
				+ password + ", date=" + date + "]";
	}
	
}
