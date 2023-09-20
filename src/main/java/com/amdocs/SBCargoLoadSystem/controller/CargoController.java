package com.amdocs.SBCargoLoadSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.SBCargoLoadSystem.model.Cargo;
import com.amdocs.SBCargoLoadSystem.serviceimpl.CargoServiceImpl;
import com.amdocs.SBCargoLoadSystem.serviceimpl.TruckServiceImpl;

@Controller
public class CargoController 
{
	@Autowired
	CargoServiceImpl cargoImpl;
	
	@Autowired 
	TruckServiceImpl truckService;

	
	@RequestMapping("/")
	public String HomePage(Model model)
	{
		model.addAttribute("msg1","Welcome to Home Page");
		return "home";
	}
	
	@RequestMapping("/cargo")
	public String AddtoDB(Model model) 
	{
		Cargo cargo = new Cargo();
		model.addAttribute("msg1","This is Cargo Page, Please fill in the details and Submit the Form");
		model.addAttribute("cargo",cargo);
		return "cargo-create";       
	}

	
	@RequestMapping("/insert")
	public String handleCargoForm(@ModelAttribute("cargo")Cargo cargo,Model model)
	{
		
		boolean saveCargo;
		String msg="";
		saveCargo = cargoImpl.saveCargo(cargo);
		if(saveCargo)
		{
			msg="Data Inserted SuccessFully";
		}
		else
		{
			msg="Data Not Inserted SuccessFully";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("msg1","This is Cargo Page, Please fill in the details and Submit the Form");
		return "cargo-create";
	}
	
	
	@RequestMapping("/viewAll")
	public String viewFromDB(Model model)
	{
		List<Cargo> allCargo = cargoImpl.getAllCargo();
		model.addAttribute("cargo", allCargo);
		System.out.println(allCargo);
		return "cargo-list";
	}
	
	
	@RequestMapping("/editCargo")
	public String editCargo(@RequestParam("cargoid") int id,Model model)
	{
		Cargo cargo = cargoImpl.getCargoId(id);
		model.addAttribute("cargo", cargo);
		return "cargo-edit";
	}
	
	@RequestMapping("/update")
	public String updateEmployee(Cargo cargo)
	{
		cargoImpl.updateCargo(cargo);
		return "redirect:/viewAll";

	}
	
	@RequestMapping("/deleteCargo")
	public String deleteEmployee(@RequestParam("cargoid") int id)
	{
		boolean flag = cargoImpl.deleteCargo(id);
		
		if(flag)
		{
			return "redirect:/viewAll";
		}
		else
		{
			return "redirect:/viewAll";
		}
	}
}
