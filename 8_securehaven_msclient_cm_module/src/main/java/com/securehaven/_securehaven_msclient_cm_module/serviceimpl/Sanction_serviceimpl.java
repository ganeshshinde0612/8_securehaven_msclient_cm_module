package com.securehaven._securehaven_msclient_cm_module.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securehaven._securehaven_msclient_cm_module.model.Application_No;
import com.securehaven._securehaven_msclient_cm_module.model.Saction_Letter;
import com.securehaven._securehaven_msclient_cm_module.repository.Sanction_Repository;
import com.securehaven._securehaven_msclient_cm_module.servicei.Sanction_Servicei;

@Service
public class Sanction_serviceimpl implements Sanction_Servicei{
	
	@Autowired 
	Sanction_Repository sr;

	@Override
	public Saction_Letter saveSanctionDetails(Saction_Letter s) {
		sr.save(s);
		
		return s;
	}

	@Override
	public List<Saction_Letter> getAllSanction() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public Saction_Letter getsanctiondetail(int app_id) {
		// TODO Auto-generated method stub
		return sr.findByAppId(app_id);
	}
	

}
