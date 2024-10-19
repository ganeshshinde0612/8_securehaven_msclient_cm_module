package com.securehaven._securehaven_msclient_cm_module.model;

import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Saction_Letter {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	private int app_id;
	
	private Date sactionDate;
	
	private String applicantName;
	
	private String mobileNo;
	
	private String email;
	
	private long loanAmountSanctioned;
	
	private int rateOfInterest;
	
	private int loanTenure;
	
	private long monthlyEmiAmount;
	
	@Lob
	@Column(length = 2000000)
	private byte[] sanctionLetter;

}
