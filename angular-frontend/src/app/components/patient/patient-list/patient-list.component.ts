import { Component, OnInit } from '@angular/core';
import { PatientService } from '../../../services/patient.service';
import {Observable} from 'rxjs';
import { Router } from '@angular/router';
import { Patient } from '../../../classes/patient';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {
  patients: Observable<Patient[]>;
  constructor(private patientService: PatientService, private route: Router) { }

  ngOnInit(): void {
    this.patients = this.patientService.getAll();
    console.log(this.patients);

  }

}
