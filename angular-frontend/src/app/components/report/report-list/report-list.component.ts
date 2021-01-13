import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/classes/patient';
import {Observable, Subscription} from "rxjs";
import {Report} from "../../../classes/report";
import {ReportService} from "../../../services/report.service";
import {PatientService} from "../../../services/patient.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Doctor} from "../../../classes/doctor";
import {DoctorService} from "../../../services/doctor.service";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-report-list',
  templateUrl: './report-list.component.html',
  styleUrls: ['./report-list.component.css']
})
export class ReportListComponent implements OnInit {

  reports: Observable<Report[]>;
  searchForm;
  constructor(private reportService: ReportService, private router: Router, private formBuilder: FormBuilder) {
    this.searchForm = this.formBuilder.group({
      name: '',
    });
  }

  ngOnInit(): void {
    console.log('Doctor List');
    this.reloadData();
  }

  reloadData(){
    this.reports = this.reportService.getAll();
    console.log(this.reports);
  }

  deleteDoctor(id: string) {
    this.reportService.delete(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
  doctorDetails(id: string){
    this.router.navigate(['reportDetails/' + id]);
  }

  updateDoctor(id: string){
    this.router.navigate(['updateReport/' + id]);
  }

  OnSubmit(searchName){
    console.log('Search Doctor Name:');
    console.log(searchName.doctorName);
    this.reports = this.reportService.findByDoctorName(searchName.doctorName);
  }

}
