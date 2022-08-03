package com.skillstorm.demo.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.media.SchemaProperty; Don't use this guy

@Entity
@Table(name = "park")
@Schema(name = "State Park")
public class Park {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "park_id")
	@Schema(description = "Park Id")
	private int id;
	
	@Column
	@Schema(description = "Park Name")
	private String name;
	
	@Column
	@Schema(description = "Location of Park")
	private String province;
	
	@Column
	@Schema(description = "Park Size in Acres")
	private double acreage;

	public Park() {
		super();
	}

	public Park(int id, String name, String province, double acreage) {
		super();
		this.id = id;
		this.name = name;
		this.province = province;
		this.acreage = acreage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public double getAcreage() {
		return acreage;
	}

	public void setAcreage(double acreage) {
		this.acreage = acreage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Park other = (Park) obj;
		return id == other.id;
	}

}
