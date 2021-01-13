import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateTutorialComponent } from './components/tutorial/create-tutorial/create-tutorial.component';
import { TutorialDetailsComponent } from './components/tutorial/tutorial-details/tutorial-details.component';
import { UpdateTutorialComponent } from './components/tutorial/update-tutorial/update-tutorial.component';
import { TutorialListComponent } from './components/tutorial/tutorial-list/tutorial-list.component';
import {PatientListComponent} from './components/patient/patient-list/patient-list.component';
import {DoctorListComponent} from './components/doctor/doctor-list/doctor-list.component';
import {AddDoctorComponent} from './components/doctor/add-doctor/add-doctor.component';
import {DoctorDetailsComponent} from './components/doctor/doctor-details/doctor-details.component';
import {DoctorUpdateComponent} from './components/doctor/doctor-update/doctor-update.component';
import {AddPatientComponent} from './components/patient/add-patient/add-patient.component';
import {PatientUpdateComponent} from './components/patient/patient-update/patient-update.component';
import {PatientDetailsComponent} from './components/patient/patient-details/patient-details.component';

const routes: Routes = [
  { path: '', redirectTo: 'tutorial', pathMatch: 'full' },
  { path: 'tutorials', component: TutorialListComponent},
  { path: 'details/:id', component: TutorialDetailsComponent },
  { path: 'create', component: CreateTutorialComponent },
  { path: 'update/:id', component: UpdateTutorialComponent},

  { path: '', redirectTo: 'doctor', pathMatch: 'full' },
  { path: 'doctors', component: DoctorListComponent},
  { path: 'doctors/add', component: AddDoctorComponent},
  { path: 'doctorDetails/:id', component: DoctorDetailsComponent },
  { path: 'updateDoctor/:id', component: DoctorUpdateComponent},

  { path: '', redirectTo: 'patient', pathMatch: 'full'},
  { path: 'patients/add', component: AddPatientComponent},
  { path: 'patients', component: PatientListComponent},
  { path: 'updatePatient/:id', component: PatientUpdateComponent},
  { path: 'patientDetails/:id', component: PatientDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
