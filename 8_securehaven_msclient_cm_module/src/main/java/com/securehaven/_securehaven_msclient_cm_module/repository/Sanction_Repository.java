package com.securehaven._securehaven_msclient_cm_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.securehaven._securehaven_msclient_cm_module.model.Saction_Letter;


@Repository
public interface Sanction_Repository extends JpaRepository<Saction_Letter, Integer>{

	@Query( value = "from Saction_Letter  where app_id = ?1")
	public Saction_Letter findByAppId(int app_id); 
}
