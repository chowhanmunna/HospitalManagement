import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddDoctorComponent } from './component/add-doctor/add-doctor.component';
import { AddPatientComponent } from './component/add-patient/add-patient.component';
import { DoctorDetailsComponent } from './component/doctor-details/doctor-details.component';
import { DoctorsComponent } from './component/doctors/doctors.component';
import { PatientsComponent } from './component/patients/patients.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'doctors',
    pathMatch: 'full'
  },
  {
    path:'doctors',
    component: DoctorsComponent
  },
  {
    path:'add/doctor',
    component: AddDoctorComponent
  },
  {
    path:'add/patient',
    component: AddPatientComponent
  },
  {
    path:'patient',
    component: PatientsComponent
  },
  {
    path:'doctor/:id',
    component: DoctorDetailsComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
