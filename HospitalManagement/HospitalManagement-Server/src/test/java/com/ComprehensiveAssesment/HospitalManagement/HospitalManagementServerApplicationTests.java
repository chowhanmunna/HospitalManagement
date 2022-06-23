package com.ComprehensiveAssesment.HospitalManagement;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ComprehensiveAssesment.HospitalManagement.Repository.DoctorRepo;
import com.ComprehensiveAssesment.HospitalManagement.Repository.PatientRepo;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)

class HospitalManagementServerApplicationTests {

	@Mock
	DoctorRepo doctorRepo;

	@Mock
	PatientRepo patientRepo;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getsAllDoctors() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/doctors").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	}

	@Test
	public void getsAllPatients() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/patients").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	}

	@Test
	public void getsSingleDoctor() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/doctors/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	}

	@Test
	public void getsSinglePatient() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/patients/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	}

	@Test
	public void returnsNotFoundForInvalidSingleDoctor() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/doctors/50").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound()).andReturn();
	}

	@Test
	public void returnsNotFoundForInvalidSinglePatient() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/patients/50").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound()).andReturn();
	}

	@Test
	public void addsNewDoctor() throws Exception {
		String newDoctor = "{\"name\":\"test name\",\"age\":25,\"gender\":\"f\",\"speciality\":\"test speciality\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/doctors").contentType(MediaType.APPLICATION_JSON)
				.content(newDoctor).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();
	}

	@Test
	public void addsNewPatient() throws Exception {
		String newDoctor = "{\"name\":\"test name\",\"prescription\":\"test prescription\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/patients/1").contentType(MediaType.APPLICATION_JSON)
				.content(newDoctor).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();
	}
}
