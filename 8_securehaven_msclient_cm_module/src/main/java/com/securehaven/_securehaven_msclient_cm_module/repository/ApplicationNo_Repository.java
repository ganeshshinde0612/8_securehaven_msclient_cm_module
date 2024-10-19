package com.securehaven._securehaven_msclient_cm_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.securehaven._securehaven_msclient_cm_module.model.Application_No;

@Repository
public interface ApplicationNo_Repository extends JpaRepository<Application_No, Integer>{

}
