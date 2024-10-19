package com.securehaven._securehaven_msclient_cm_module.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securehaven._securehaven_msclient_cm_module.model.Application_No;
import com.securehaven._securehaven_msclient_cm_module.model.Customer_Loan_Application;
import com.securehaven._securehaven_msclient_cm_module.model.Saction_Letter;
import com.securehaven._securehaven_msclient_cm_module.servicei.ApplicationNo_Servicei;
import com.securehaven._securehaven_msclient_cm_module.servicei.Sanction_Servicei;
import com.securehaven._securehaven_msclient_cm_module.utility.Email_Sender;

import jakarta.mail.MessagingException;

@CrossOrigin("*")
@RestController
public class CM_Controller {
	
	@Autowired
	RestTemplate rt;
	
	@Autowired
	Sanction_Servicei ssi;
	
	@Autowired
	ApplicationNo_Servicei asi; 
	
	@Autowired
	Email_Sender es;
	
	@GetMapping(value = "/get_accepted_loan_app")
	public ResponseEntity<List<Customer_Loan_Application>> getLoanForm()
	{
		
		String url="http://localhost:9098/get_accepted_app";
		
		Customer_Loan_Application[] ca=rt.getForObject(url, Customer_Loan_Application[].class);
		List<Customer_Loan_Application> list=new ArrayList<Customer_Loan_Application>(Arrays.asList(ca));
		
		return new ResponseEntity<List<Customer_Loan_Application>>(list,HttpStatus.OK);
	}
	
	@PostMapping(value = "/save_sanction_details")
	public ResponseEntity<Saction_Letter> saveSanctionDetails(@RequestBody Saction_Letter s)
	{
		s.setSactionDate(new Date());
		Saction_Letter sl=ssi.saveSanctionDetails(s);
		
		return new ResponseEntity<Saction_Letter> (s, HttpStatus.OK);
	}
	
	@PostMapping(value = "/save_forwarded_app/{app_id}")
	public ResponseEntity<Application_No> saveForwardedApp(@PathVariable("app_id") int id)
	{
		Application_No a=new Application_No();
		a.setId(id);
		
		asi.saveForwardedApp(a);
		
		return new ResponseEntity<Application_No> (a, HttpStatus.OK);
	}
	
//	@PostMapping(value = "/send_sanctioned_Email")
//	public ResponseEntity<String> sendSanctionedEmail(@RequestPart("json") String jsonData ,@RequestPart ("sanction_letter") MultipartFile f) throws MessagingException, IOException
//	{
//		
//		ObjectMapper om=new ObjectMapper();
//		Saction_Letter ca=om.readValue(jsonData, Saction_Letter.class);
//		
//		System.out.println(f.getOriginalFilename());
//		
//		ca.setSanctionLetter(f.getBytes());
//		
//		ssi.saveSanctionDetails(ca);
////		es.sendSanctionEmail(ca,f);
//		
//		return new ResponseEntity<String> ("success", HttpStatus.OK);
//	}
	@GetMapping("/forward_sanction_details")
	public ResponseEntity<List<Saction_Letter >> forwardsanction()
	{
		List<Saction_Letter> list =ssi.getAllSanction();
		
		return new ResponseEntity<List<Saction_Letter>>(list,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/forward_single_sanction_details/{app_id}")
	public ResponseEntity<Saction_Letter > forwardsinglesanction(@PathVariable("app_id") int app_id)
	{
		Saction_Letter sl=ssi.getsanctiondetail(app_id);
		
		return new ResponseEntity<Saction_Letter>(sl,HttpStatus.OK);
	}
	
	@GetMapping("/forward_loan_status/{app_id}")
	public ResponseEntity<Saction_Letter> forwordloanstatus(@PathVariable("app_id") int app_id)
	{
		
		Saction_Letter sl= ssi.getsanctiondetail(app_id);
		return new ResponseEntity<Saction_Letter>(sl,HttpStatus.OK);
	}

}
