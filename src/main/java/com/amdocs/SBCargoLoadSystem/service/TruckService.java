package com.amdocs.SBCargoLoadSystem.service;

import java.util.List;

import com.amdocs.SBCargoLoadSystem.exception.CargoNotFoundException;
import com.amdocs.SBCargoLoadSystem.exception.InvalidTruckException;
import com.amdocs.SBCargoLoadSystem.model.Truck;

public interface TruckService 
{
	public Truck saveTruck(int cargoid, Truck truck) throws CargoNotFoundException;
	
	public List<Truck> getAllTruck();
	
	public Truck getTruckId(int id) throws InvalidTruckException;

	public void deleteTruck(int id);
	
	public List<Truck> getTruckByCargoId(int cargoid) throws CargoNotFoundException;


	public Truck updateTruckBook(int cargoid, int truckId, Truck truck) throws InvalidTruckException,CargoNotFoundException;
}
