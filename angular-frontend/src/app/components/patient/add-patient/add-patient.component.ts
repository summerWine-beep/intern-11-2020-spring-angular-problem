import { Component, OnInit } from '@angular/core';
import {PatientService} from "../../../services/patient.service";
import {DoctorService} from "../../../services/doctor.service";
import {Route, Router} from "@angular/router";
import {Patient} from "../../../classes/patient";
import {Observable} from "rxjs";
import {Doctor} from "../../../classes/doctor";

@Component({
  selector: 'app-add-patient',
  templateUrl: `./add-patient.component.html`,
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {
  patients: Patient = new Patient();
  submitted = false;
  doctors: Observable<Doctor[]>;


  constructor(private patientService: PatientService, private doctorService: DoctorService, private router: Router) { }

  ngOnInit(): void {
    this.doctors = this.doctorService.getAll();
  }
  newPatient(): void {
    this.submitted = false;
    this.patients = new Patient();
  }

  save() {
    this.patientService
      .create(this.patients).subscribe(data => {
        console.log(data);
        this.patients = new Patient();
        console.log(this.patients);
        this.gotoList();
      },
      error => console.log(error));
  }
  onSubmit(){
    this.submitted = true;
    this.save();
  }
  gotoList(){
    this.router.navigate(['/patients']);
  }

}
