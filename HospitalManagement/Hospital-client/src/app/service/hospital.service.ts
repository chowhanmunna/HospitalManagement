import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Doctor } from '../entity/doctor';
import { Patient } from '../entity/patient';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};
@Injectable({
  providedIn: 'root'
})
export class HospitalService {

  private apiUrl: string = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  getDoctors():Observable<Doctor[]>{
    return this.http.get<Doctor[]>(this.apiUrl + "doctors",httpOptions);
  }

  getPatients():Observable<Patient[]>{
    return this.http.get<Patient[]>(this.apiUrl + "patients",httpOptions);
  }

  getDoctor(id: number):Observable<Doctor>{
    return this.http.get<Doctor>(this.apiUrl + "doctors/" + id,httpOptions);
  }

  addDoctor(doctor: Doctor):Observable<Doctor>{
    return this.http.post<Doctor>(this.apiUrl + "doctors",doctor,httpOptions);
  }

  getNumberOfPatients(id:number):Observable<number>{
    return this.http.get<number>(this.apiUrl + "doctors/" + id + "/patients",httpOptions);
  }

  getPatient(id:number):Observable<Patient>{
    return this.http.get<Patient>(this.apiUrl + "patients/"+id,httpOptions);
  }

  addPatient(patient:Patient,doctorId:number):Observable<Patient>{
    return this.http.post<Patient>(this.apiUrl + "patients/"+doctorId,patient,httpOptions);
  }

}
