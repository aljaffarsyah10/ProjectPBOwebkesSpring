package com.aljaffarsyah.webkes.service;

import java.util.List;

import com.aljaffarsyah.webkes.entity.Patient;

public interface PatientService {
	List<Patient> getAllPatients();
	
	Patient savePatient(Patient patient);
	
	Patient getPatientById(Long id);
	
	Patient updatePatient(Patient patient);
	
	void deletePatientById(Long id);
}
