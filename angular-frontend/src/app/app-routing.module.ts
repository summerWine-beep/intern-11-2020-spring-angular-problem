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

const routes: Routes = [
  { path: '', redirectTo: 'tutorial', pathMatch: 'full' },
  { path: 'tutorials', component: TutorialListComponent},
  { path: 'details/:id', component: TutorialDetailsComponent },
  { path: 'create', component: CreateTutorialComponent },
  { path: 'update/:id', component: UpdateTutorialComponent},
  { path: 'patients', component: PatientListComponent},
  { path: '', redirectTo: 'doctor', pathMatch: 'full' },
  { path: 'doctors', component: DoctorListComponent},
  { path: 'doctors/add', component: AddDoctorComponent},
  { path: 'doctorDetails/:id', component: DoctorDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
