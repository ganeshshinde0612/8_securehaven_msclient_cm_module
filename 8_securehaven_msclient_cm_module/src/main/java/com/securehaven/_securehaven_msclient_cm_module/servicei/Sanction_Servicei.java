package com.securehaven._securehaven_msclient_cm_module.servicei;

import java.util.List;

import com.securehaven._securehaven_msclient_cm_module.model.Application_No;
import com.securehaven._securehaven_msclient_cm_module.model.Saction_Letter;

public interface Sanction_Servicei {

	public Saction_Letter saveSanctionDetails(Saction_Letter s);

	public List<Saction_Letter> getAllSanction();

	public Saction_Letter getsanctiondetail(int app_id);

	

}
