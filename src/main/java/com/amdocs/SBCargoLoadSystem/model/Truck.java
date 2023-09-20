package com.amdocs.SBCargoLoadSystem.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Truck")
public class Truck 
{
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int truckId;
	
	@Column(name ="TruckName")
	private String truckName;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="truckList")
	private Cargo cargo;
 
	
	@Column(name="TruckRegistration")  
	private String truckReg;  
	
	@Column(name="MaxCapacity")
	private int maxCap;

	@Override
	public String toString() {
		return "[truckId=" + truckId + ", truckName=" + truckName + ", truckReg=" + truckReg + ", maxCap="
				+ maxCap + "]";
	}
	
	
}
