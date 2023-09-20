package com.amdocs.SBCargoLoadSystem.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.ToString;

@Entity
public class Cargo 
{
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cargoId;
	
	@JsonManagedReference
	@OneToMany(mappedBy="cargo",cascade=CascadeType.ALL)
	private List<Truck> truckList;
	
	@Column(name="Type")
	private String cargoType;
	
	@Column(name="CargoLoad")
	private int cargoLoad;
	
	@Column(name="CargoIssuer")
	private String cargoIssuer;

	public int getCargoId() {
		return cargoId;
	}

	public void setCargoId(int cargoId) {
		this.cargoId = cargoId;
	}

	public List<Truck> getTruckList() {
		return truckList;
	}

	public void setTruckList(List<Truck> truckList) {
		this.truckList = truckList;
	}

	public String getCargoType() {
		return cargoType;
	}

	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}

	public int getCargoLoad() {
		return cargoLoad;
	}

	public void setCargoLoad(int cargoLoad) {
		this.cargoLoad = cargoLoad;
	}

	public String getCargoIssuer() {
		return cargoIssuer;
	}

	public void setCargoIssuer(String cargoIssuer) {
		this.cargoIssuer = cargoIssuer;
	}

	public Cargo() {
		super();
	}

	public Cargo(int cargoId, List<Truck> truckList, String cargoType, int cargoLoad, String cargoIssuer) {
		super();
		this.cargoId = cargoId;
		this.truckList = truckList;
		this.cargoType = cargoType;
		this.cargoLoad = cargoLoad;
		this.cargoIssuer = cargoIssuer;
	}
	
	
	
	
}
