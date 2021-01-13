import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Report } from '../../../classes/report';
import { Patient } from '../../../classes/patient';
import { Doctor} from '../../../classes/doctor';
import { DoctorService} from '../../../services/doctor.service';
import { PatientService} from '../../../services/patient.service';
import { ReportService } from '../../../services/report.service';
import { Observable } from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-add-report',
  templateUrl: `./add-report.component.html`,
  styleUrls: ['./add-report.component.css']
})
export class AddReportComponent implements OnInit {

  report: Report = new Report();
  submitted = false;
  reportID: string;
  patientID: string;
  patients: Observable<Patient[]>;
  doctors: Observable<Doctor[]>;
  patient: Patient;

  reportForm = this.fb.group({
    patientid: '',
    doctorid: '',
    bloodpressure: '',
    pulserate: '',
    weight: '',
    patienthistory: '',
    followupdoctorid: '',
  });

  constructor(private patientService: PatientService,
              private doctorService: DoctorService,
              private reportService: ReportService,
              private route: ActivatedRoute,
              private router: Router,
              private fb: FormBuilder) {
  }

  ngOnInit() {
    this.doctors = this.doctorService.getAll();
    this.patients = this.patientService.getAll();
    this.patientID = this.route.snapshot.params['id'.toString()];
    this.patient = new Patient();
    if (this.patientID) {
      try {
        this.patientService.get(this.patientID).subscribe(
          patientData => {
            this.patient = patientData;
            this.reportForm.patchValue({
              patientid: this.patient.id,
              doctorid: this.patient.doctorid
            });
            console.log(this.patient);
          }
        );
      } catch ( e ) {
        console.log('Failed to load patient data');
      }
    }
  }

  save() {
    this.report = this.reportForm.value;
    console.log(this.report);
    this.reportService
      .create(this.report).subscribe(data => {
        this.report = data;
        console.log(data);
        this.report = new Report();
        this.gotoList();
      },
      error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate([ 'reports']);
  }

  cancelAdd() {
    this.router.navigate([ 'reports' ]);
  }

}
