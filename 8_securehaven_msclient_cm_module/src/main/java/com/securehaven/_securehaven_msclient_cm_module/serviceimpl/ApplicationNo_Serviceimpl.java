package com.securehaven._securehaven_msclient_cm_module.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securehaven._securehaven_msclient_cm_module.model.Application_No;
import com.securehaven._securehaven_msclient_cm_module.repository.ApplicationNo_Repository;
import com.securehaven._securehaven_msclient_cm_module.servicei.ApplicationNo_Servicei;

@Service
public class ApplicationNo_Serviceimpl implements ApplicationNo_Servicei{

	@Autowired
	ApplicationNo_Repository ar;
	
	@Override
	public void saveForwardedApp(Application_No a) {
		
		ar.save(a);
	}

}
