package com.ComprehensiveAssesment.HospitalManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ComprehensiveAssesment.HospitalManagement.Entity.Doctor;
import com.ComprehensiveAssesment.HospitalManagement.Entity.Patient;
import com.ComprehensiveAssesment.HospitalManagement.Exception.DataNotFoundException;
import com.ComprehensiveAssesment.HospitalManagement.Repository.DoctorRepo;
import com.ComprehensiveAssesment.HospitalManagement.Repository.PatientRepo;

@Service
public class HospitalServiceImpl implements HospitalService {

	private final DoctorRepo doctorRepo;
	private final PatientRepo patientRepo;

	@Autowired
	public HospitalServiceImpl(DoctorRepo doctorRepo, PatientRepo patientRepo) {
		this.doctorRepo = doctorRepo;
		this.patientRepo = patientRepo;
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}

	@Override
	public Patient addPatient(Patient patient, Long doctorId) {
		Doctor visitedDoctor = doctorRepo.findById(doctorId)
				.orElseThrow(() -> new DataNotFoundException("No Doctor found with Id : " + doctorId));
		patient.setVisitedDoctor(visitedDoctor);
		return patientRepo.save(patient);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepo.findAll();
	}
	@Override
	public List<Patient> getAllPatients() {
		return patientRepo.findAll();
	}

	@Override
	public Doctor getDoctorDetails(Long doctorId) {
		return doctorRepo.findById(doctorId)
				.orElseThrow(() -> new DataNotFoundException("No Doctor found with Id : " + doctorId));
	}

	@Override
	public int getNumberOfPatientsAttended(Long doctorId) {
		return getDoctorDetails(doctorId).getPatients().size();
	}

	@Override
	public Patient getPatientDetails(Long patientId) {
		return patientRepo.findById(patientId)
				.orElseThrow(() -> new DataNotFoundException("No Patient found with Id : " + patientId));
	}

}
