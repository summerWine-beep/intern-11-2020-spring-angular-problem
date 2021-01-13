import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { TutorialDetailsComponent } from './components/tutorial/tutorial-details/tutorial-details.component';
import { CreateTutorialComponent } from './components/tutorial/create-tutorial/create-tutorial.component';
import { UpdateTutorialComponent } from './components/tutorial/update-tutorial/update-tutorial.component';
import { TutorialListComponent } from './components/tutorial/tutorial-list/tutorial-list.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { PatientListComponent } from './components/patient/patient-list/patient-list.component';
import { AddReportComponent } from './components/report/add-report/add-report.component';
import { DoctorDetailsComponent } from './components/doctor/doctor-details/doctor-details.component';
import { DoctorListComponent } from './components/doctor/doctor-list/doctor-list.component';
import { PatientDetailsComponent } from './components/patient/patient-details/patient-details.component';
import { AddDoctorComponent } from './components/doctor/add-doctor/add-doctor.component';
import { DoctorUpdateComponent } from './components/doctor/doctor-update/doctor-update.component';
import { PatientUpdateComponent } from './components/patient/patient-update/patient-update.component';
import { AddPatientComponent } from './components/patient/add-patient/add-patient.component';

@NgModule({
  declarations: [
    AppComponent,
    TutorialDetailsComponent,
    CreateTutorialComponent,
    UpdateTutorialComponent,
    TutorialListComponent,
    PatientListComponent,
    AddReportComponent,
    DoctorDetailsComponent,
    DoctorListComponent,
    PatientDetailsComponent,
    AddDoctorComponent,
    DoctorUpdateComponent,
    PatientUpdateComponent,
    AddPatientComponent
  ],
    imports: [
        RouterModule,
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
