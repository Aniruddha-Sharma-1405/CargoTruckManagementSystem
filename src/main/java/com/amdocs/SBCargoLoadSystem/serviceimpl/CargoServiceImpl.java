package com.amdocs.SBCargoLoadSystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.SBCargoLoadSystem.model.Cargo;
import com.amdocs.SBCargoLoadSystem.repo.CargoRepository;
import com.amdocs.SBCargoLoadSystem.repo.TruckRepository;
import com.amdocs.SBCargoLoadSystem.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService
{
	
	@Autowired
	CargoRepository cargoRepo;
	
	@Autowired 
	TruckRepository truckRepo;
	
	@Override
	public boolean saveCargo(Cargo cargo) 
	{
		boolean check = false;
		Cargo CargoSave = cargoRepo.save(cargo);
		if(CargoSave!=null)
		{
			check = true;
		}
		return check;
	}

	@Override
	public List<Cargo> getAllCargo() 
	{
		List<Cargo> cargoRecords = cargoRepo.findAll();
		return cargoRecords;
	}

	@Override
	public Cargo getCargoId(int id) 
	{
		Optional<Cargo> cargoId = cargoRepo.findById(id);
		Cargo cargo = cargoId.get();
		return cargo;
	}

	@Override
	public boolean updateCargo(Cargo cr) 
	{
		return saveCargo(cr);
	}

	@Override
	public boolean deleteCargo(int id) 
	{
		Cargo cargo = getCargoId(id);
		boolean flag;
		if(cargo!=null)
		{
			cargoRepo.delete(cargo);
			flag = true;
		}
		else
		{
			flag = false;
		}
		return flag;
	}		
	
}
