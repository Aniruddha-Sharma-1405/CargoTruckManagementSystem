package com.amdocs.SBCargoLoadSystem.service;

import java.util.List;

import com.amdocs.SBCargoLoadSystem.model.Cargo;

public interface CargoService 
{
	public boolean saveCargo(Cargo cargo);
	
	public List<Cargo> getAllCargo();
	
	public Cargo getCargoId(int id);

	public boolean updateCargo(Cargo cr);

	public boolean deleteCargo(int id);
}
