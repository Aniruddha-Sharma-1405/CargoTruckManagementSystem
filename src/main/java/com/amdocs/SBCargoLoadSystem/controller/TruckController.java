package com.amdocs.SBCargoLoadSystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.SBCargoLoadSystem.exception.CargoNotFoundException;
import com.amdocs.SBCargoLoadSystem.exception.InvalidTruckException;
import com.amdocs.SBCargoLoadSystem.model.Cargo;
import com.amdocs.SBCargoLoadSystem.model.Truck;
import com.amdocs.SBCargoLoadSystem.serviceimpl.CargoServiceImpl;
import com.amdocs.SBCargoLoadSystem.serviceimpl.TruckServiceImpl;

@RestController
@RequestMapping("/trucks")
public class TruckController 
{
	private TruckServiceImpl truckService;
	
	private CargoServiceImpl cargoService;
	
	@Autowired(required=true)
	public TruckController(TruckServiceImpl truckService, CargoServiceImpl cargoService)
	{
		this.cargoService=cargoService;
		this.truckService= truckService;
	}
	
	@PostMapping("/insertTruck/{cargoid}")
	public Truck getTruckByCargoId(@RequestBody Truck truck,@PathVariable Integer cargoid)
	{
		Truck t=null;
		try
		{
			t=truckService.saveTruck(cargoid,truck);
		}
		catch(CargoNotFoundException e)
		{
			System.err.println("Please Enter Valid Cargo Id");
		}
		return t;
	}
	
	@PostMapping
	public boolean saveCargo(@RequestBody Cargo cargo)
	{
		return cargoService.saveCargo(cargo);
	}
	
	@GetMapping("/allTrucks")
	public List<Truck> getAllTruck()
	{
		return truckService.getAllTruck();
	}
	
	@GetMapping("/{truckId}")
	public Truck getTruckById(@PathVariable int truckId)
	{
		Truck t = null;
		try 
		{
			t=truckService.getTruckId(truckId);
		} 
		catch (InvalidTruckException e) 
		{
			System.err.println("Invalid Truck ID");
		}
		return t;
	}
	
	@PutMapping("/update/{cargoid}/{truckId}")
	public Truck updateTruck(@PathVariable int truckId,@PathVariable int cargoid, @RequestBody Truck truck)
	{
		Truck t=null;
		try 
		{
			t=truckService.updateTruckBook(cargoid,truckId,truck);
		} 
		catch (InvalidTruckException e) 
		{
			System.err.println("Invalid Truck Id!");
		} 
		catch (CargoNotFoundException e) 
		{
			System.err.println("Invalid Cargo Id");
		}
		return t;
	}
	
	@DeleteMapping("/delete/{truckId}")
	public void deleteTruck(@PathVariable int truckId)
	{
		truckService.deleteTruck(truckId);
	}
	
	
}
