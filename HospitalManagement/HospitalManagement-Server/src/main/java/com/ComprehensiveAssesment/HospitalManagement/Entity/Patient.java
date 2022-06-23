package com.ComprehensiveAssesment.HospitalManagement.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;

	@Column(name = "Patient_Name")
	private String name;

	@OneToOne
	private Doctor visitedDoctor;
	
	@CreationTimestamp
	private Date dateOfVisit;

	private String prescription;

	protected Patient() {

	}

	public Patient(Long patientId, String name, Doctor visitedDoctor, Date dateOfVisit, String prescription) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
		this.prescription = prescription;
	}

	/**
	 * @return the patientId
	 */
	public Long getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the visitedDoctor
	 */
	public Doctor getVisitedDoctor() {
		return visitedDoctor;
	}

	/**
	 * @param visitedDoctor the visitedDoctor to set
	 */
	public void setVisitedDoctor(Doctor visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}

	/**
	 * @return the dateOfVisit
	 */
	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	/**
	 * @param dateOfVisit the dateOfVisit to set
	 */
	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	/**
	 * @return the prescription
	 */
	public String getPrescription() {
		return prescription;
	}

	/**
	 * @param prescription the prescription to set
	 */
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", visitedDoctor=" + visitedDoctor
				+ ", dateOfVisit=" + dateOfVisit + ", prescription=" + prescription + "]";
	}

}
