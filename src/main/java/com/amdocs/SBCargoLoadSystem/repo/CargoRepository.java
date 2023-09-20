package com.amdocs.SBCargoLoadSystem.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.SBCargoLoadSystem.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer>
{
	
}
