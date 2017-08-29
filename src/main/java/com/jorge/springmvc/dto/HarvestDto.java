package com.jorge.springmvc.dto;

import java.util.Date;

public class HarvestDto {
  
  private Float weight;
  private Float price;
  private String comments;
  private Date date;
  
  public Float getWeight() {
    return weight;
  }

  public void setWeight(Float weight) {
    this.weight = weight;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
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
