package com.aljaffarsyah.webkes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aljaffarsyah.webkes.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
