package com.ComprehensiveAssesment.HospitalManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ComprehensiveAssesment.HospitalManagement.Entity.Doctor;
import com.ComprehensiveAssesment.HospitalManagement.Entity.Patient;

@Service
public interface HospitalService {

	public Doctor addDoctor(Doctor doctor);
	
	public Patient addPatient(Patient patient,Long doctorId);
	
	public List<Doctor> getAllDoctors();
	public Doctor getDoctorDetails(Long doctorId);
	public int getNumberOfPatientsAttended(Long doctorId);
	
	public Patient getPatientDetails(Long patientId);

	List<Patient> getAllPatients();


}
