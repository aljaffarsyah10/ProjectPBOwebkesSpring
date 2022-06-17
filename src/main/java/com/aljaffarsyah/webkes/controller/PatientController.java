package com.aljaffarsyah.webkes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aljaffarsyah.webkes.entity.Patient;
import com.aljaffarsyah.webkes.service.PatientService;

//import net.javaguides.sms.entity.Patient;
//import net.javaguides.sms.service.PatientService;

@Controller
public class PatientController {

	private PatientService patientService;
	
	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}

	// handler method to handle list patients and return mode and view
	@GetMapping("/patients")
	public String listPatients(Model model) {
		model.addAttribute("patients", patientService.getAllPatients());
		return "patients";
	}
	
	@GetMapping("/patients/new")
	public String createPatientForm(Model model) {
		
		// create patient object to hold patient form data
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		return "create_patient";
		
	}
	
	@PostMapping("/patients")
	public String savePatient(@ModelAttribute("patient") Patient patient) {
		patientService.savePatient(patient);
		return "redirect:/patients";
	}
	
	@GetMapping("/patients/edit/{id}")
	public String editPatientForm(@PathVariable Long id, Model model) {
		model.addAttribute("patient", patientService.getPatientById(id));
		return "edit_patient";
	}

	@PostMapping("/patients/{id}")
	public String updatePatient(@PathVariable Long id,
			@ModelAttribute("patient") Patient patient,
			Model model) {
		
		// get patient from database by id
		Patient existingPatient = patientService.getPatientById(id);
		existingPatient.setId(id);
		existingPatient.setName(patient.getName());
		existingPatient.setProfession(patient.getProfession());
		existingPatient.setComplaint(patient.getComplaint());
		
		// save updated patient object
		patientService.updatePatient(existingPatient);
		return "redirect:/patients";		
	}
	
	// handler method to handle delete patient request
	
	@GetMapping("/patients/{id}")
	public String deletePatient(@PathVariable Long id) {
		patientService.deletePatientById(id);
		return "redirect:/patients";
	}
		
	
}
