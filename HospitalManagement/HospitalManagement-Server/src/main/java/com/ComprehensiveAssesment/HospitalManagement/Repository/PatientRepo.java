package com.ComprehensiveAssesment.HospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ComprehensiveAssesment.HospitalManagement.Entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {

}
