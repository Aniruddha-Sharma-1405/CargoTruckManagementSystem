package com.amdocs.SBCargoLoadSystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.SBCargoLoadSystem.model.Cargo;
import com.amdocs.SBCargoLoadSystem.model.Truck;

@Repository
public interface TruckRepository extends JpaRepository<Truck,Integer> 
{
	List<Truck> findByCargo(Cargo cargo);
	
	Truck findByCargoAndTruckId(Cargo cargo, Integer truckId);
}
