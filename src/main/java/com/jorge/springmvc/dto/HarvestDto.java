package com.jorge.springmvc.dto;

import java.util.Date;

public class HarvestDto {
  
  private Integer weight;
  private Integer price;
  private String comments;
  private Date date;
  
  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getComments() {
    return comments;
  }
  
  public void setComments(String comments) {
    this.comments = comments;
  }

  @Override
  public String toString() {
    return "HarvestDto [weight=" + weight + ", price=" + price + ", comments=" + comments
        + ", date=" + date + "]";
  }
  
  
}
