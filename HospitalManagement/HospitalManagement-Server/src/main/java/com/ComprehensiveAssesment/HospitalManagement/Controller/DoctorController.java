package com.ComprehensiveAssesment.HospitalManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ComprehensiveAssesment.HospitalManagement.Entity.Doctor;
import com.ComprehensiveAssesment.HospitalManagement.Service.HospitalService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/doctors")
public class DoctorController {

	final public HospitalService service;

	@Autowired
	public DoctorController(HospitalService service) {
		super();
		this.service = service;
	}

	@GetMapping
	private ResponseEntity<List<Doctor>> getAllDoctors() {
		try {
			List<Doctor> doctors = service.getAllDoctors();
			if (doctors.isEmpty())
				return new ResponseEntity<List<Doctor>>(HttpStatus.NO_CONTENT);
			else
				return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	private ResponseEntity<?> getDoctor(@PathVariable Long id) {
		try {
			Doctor doctor = service.getDoctorDetails(id);

			return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);

		} catch (Exception e) {
			if (e.getMessage().contains("No Doctor found with Id :"))
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	private ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
		try {
			Doctor doctor1 = service.addDoctor(doctor);
			return new ResponseEntity<Doctor>(doctor1, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}/patients")
	private ResponseEntity<?> getNumberOfPatients(@PathVariable Long id){
		try {
			return new ResponseEntity<>(service.getNumberOfPatientsAttended(id),HttpStatus.OK);
		}catch (Exception e) {
			if (e.getMessage().contains("No Doctor found with Id :"))
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
