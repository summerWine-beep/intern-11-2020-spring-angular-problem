import { Component, OnInit } from '@angular/core';
import {Report} from "../../../classes/report";
import {Observable} from "rxjs";
import {Patient} from "../../../classes/patient";
import {Doctor} from "../../../classes/doctor";
import {PatientService} from "../../../services/patient.service";
import {DoctorService} from "../../../services/doctor.service";
import {ReportService} from "../../../services/report.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormArray, FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-add-report',
  templateUrl: './add-report.component.html',
  styleUrls: ['./add-report.component.css']
})
export class AddReportComponent implements OnInit {

  report: Report = new Report();
  submitted = false;

  constructor(private reportService: ReportService,
              private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
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
