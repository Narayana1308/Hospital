package com.ty.one_to_many_hospital_branch_dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	private int address_id;
	private String area_name;
	private int road_Num;
	private int pincode;
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public int getRoad_Num() {
		return road_Num;
	}
	public void setRoad_Num(int road_Num) {
		this.road_Num = road_Num;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", area_name=" + area_name + ", road_Num=" + road_Num
				+ ", pincode=" + pincode + "]";
	}
	
	

}
