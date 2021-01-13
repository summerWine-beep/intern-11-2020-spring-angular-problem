import { Component, OnInit } from '@angular/core';
import {Report} from '../../../classes/report';
import {Observable} from 'rxjs';
import {Patient} from '../../../classes/patient';
import {Doctor} from '../../../classes/doctor';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {PatientService} from '../../../services/patient.service';
import {DoctorService} from '../../../services/doctor.service';
import {ReportService} from '../../../services/report.service';
import {ActivatedRoute, Router} from '@angular/router';


@Component({
  selector: 'app-update-report',
  templateUrl: './update-report.component.html',
  styleUrls: ['./update-report.component.css']
})
export class UpdateReportComponent implements OnInit {

  report: Report = new Report();
  reportID: string;
  patientID: string;
  patients: Observable<Patient[]>;
  doctors: Observable<Doctor[]>;

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
    this.reportID = this.route.snapshot.params['id'.toString()];
    this.reportService.get(this.reportID).subscribe(
      reportData => {
        this.report = reportData;
        this.reportForm.patchValue({
          patientid: this.report.patientid,
          doctorid: this.report.doctorid,
          bloodpressure: this.report.bloodpressure,
          pulserate: this.report.pulserate,
          weight: this.report.weight,
          patienthistory: this.report.patienthistory,
          followupdoctorid: this.report.followupdoctorid,
        });
      }
    );
  }

  update() {
    this.report = this.reportForm.value;
    this.reportService
      .update(this.reportID, this.report).subscribe(reportData => {
        this.report = reportData;
        console.log(this.report);
        this.gotoList();
      },
      error => console.log(error));
  }

  onSubmit() {
    this.update();
  }

  gotoList() {
    this.router.navigate([ 'reports' ]);
  }

  cancelAdd() {
    this.router.navigate([ 'reports' ]);
  }

}
