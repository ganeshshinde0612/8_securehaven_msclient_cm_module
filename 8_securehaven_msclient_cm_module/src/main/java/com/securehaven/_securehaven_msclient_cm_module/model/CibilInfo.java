package com.securehaven._securehaven_msclient_cm_module.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CibilInfo {
	
	private int id;
	private int cibilScore;
	private Date cibilDate;

}
