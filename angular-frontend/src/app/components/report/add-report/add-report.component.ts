import { Component, OnInit } from '@angular/core';
import {Report} from '../../../classes/report';
import {ReportService} from '../../../services/report.service';
import {ActivatedRoute, Router} from '@angular/router';
import {PatientService} from '../../../services/patient.service';
import {DoctorService} from '../../../services/doctor.service';
import {Observable} from 'rxjs';
import {Patient} from '../../../classes/patient';
import {Doctor} from '../../../classes/doctor';

@Component({
  selector: 'app-add-report',
  templateUrl: './add-report.component.html',
  styleUrls: ['./add-report.component.css']
})
export class AddReportComponent implements OnInit {
  report: Report = new Report();
  submitted = false;
  reportID: string;
  patientID: string;
  patients: Observable<Patient[]>;
  doctors: Observable<Doctor[]>;
  Patient: Patient;

  constructor(private reportService: ReportService,
              private patientService: PatientService,
              private doctorService: DoctorService,
              private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.doctors = this.doctorService.getAll();
    this.patients = this.patientService.getAll();
  }

  newReport(): void {
    this.submitted = false;
    this.report = new Report();
  }

  save() {
    this.reportService
      .create(this.report).subscribe(data => {
        console.log(data);
        this.report = new Report();
        console.log(this.report);
        this.gotoList();
      },
      error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/reports']);
  }

}
