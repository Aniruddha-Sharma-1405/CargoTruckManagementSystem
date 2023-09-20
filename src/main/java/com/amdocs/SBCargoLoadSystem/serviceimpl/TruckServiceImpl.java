package com.amdocs.SBCargoLoadSystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.SBCargoLoadSystem.exception.CargoNotFoundException;
import com.amdocs.SBCargoLoadSystem.exception.InvalidTruckException;
import com.amdocs.SBCargoLoadSystem.model.Cargo;
import com.amdocs.SBCargoLoadSystem.model.Truck;
import com.amdocs.SBCargoLoadSystem.repo.CargoRepository;
import com.amdocs.SBCargoLoadSystem.repo.TruckRepository;
import com.amdocs.SBCargoLoadSystem.service.TruckService;

@Service
public class TruckServiceImpl implements TruckService
{
	@Autowired
	private TruckRepository truckRepo;
	
	@Autowired
	private CargoRepository cargoRepo;
	
	@Override
	public Truck saveTruck(int cargoid, Truck truck) throws CargoNotFoundException
	{
		Cargo cargo = cargoRepo.findById(cargoid).orElse(null);
		if(cargo==null)
		{
			throw new CargoNotFoundException("Please Mention Valid CargoId");
		}
		truck.setCargo(cargo);
		Truck truckSave = truckRepo.save(truck);
		return truckSave;
	}
	
	@Override
	public List<Truck> getAllTruck() 
	{
		List<Truck> truckList = truckRepo.findAll();
		return truckList;
	}

	@Override
	public Truck getTruckId(int id) throws InvalidTruckException
	{
		Truck truckId = truckRepo.findById(id).orElse(null);
		if(truckId == null)
		{
			throw new InvalidTruckException("Please Enter a valid Truck Id");
		}
		return truckId;
	}

	@Override
	public Truck updateTruckBook(int cargoid,int truckId,Truck truck) throws InvalidTruckException,CargoNotFoundException
	{
		Cargo cargo = cargoRepo.findById(cargoid).orElse(null);
		if(cargo==null)
		{
			throw new CargoNotFoundException("Update");
		}
		Truck existingtruck =truckRepo.findByCargoAndTruckId(cargo,truckId);
		if(existingtruck==null)
		{
			throw new InvalidTruckException("Upating");
		}
		
		if(existingtruck!=null)
		{
			existingtruck.setTruckName(truck.getTruckName());
			existingtruck.setTruckReg(truck.getTruckReg());
			existingtruck.setMaxCap(truck.getMaxCap());
			return truckRepo.save(existingtruck);
		}
		return existingtruck;
	}

	@Override
	public void deleteTruck(int id) 
	{
		Truck truck=null;
		try 
		{
			truck = getTruckId(id);
			truckRepo.delete(truck);
		} 
		catch (InvalidTruckException e) 
		{
			System.err.println("Invalid Truck Id in Delete");
		}
	}

	@Override
	public List<Truck> getTruckByCargoId(int cargoid) throws CargoNotFoundException
	{
		Cargo cargo = cargoRepo.findById(cargoid).orElse(null);
		if(cargo==null)
		{
			throw new CargoNotFoundException("getTruckByCargoId");
		}
		return truckRepo.findByCargo(cargo);
	}

}
