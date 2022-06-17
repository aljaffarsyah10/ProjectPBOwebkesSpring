package com.aljaffarsyah.webkes.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aljaffarsyah.webkes.entity.Patient;
import com.aljaffarsyah.webkes.repository.PatientRepository;
import com.aljaffarsyah.webkes.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	private PatientRepository patientRepository;
	
	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Patient getPatientById(Long id) {
		return patientRepository.findById(id).get();
	}

	@Override
	public Patient updatePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public void deletePatientById(Long id) {
		patientRepository.deleteById(id);	
	}


}
