import { Component, OnInit } from '@angular/core';
import {Observable, Subscription} from 'rxjs';
import {Report} from '../../../classes/report';
import {ReportService} from '../../../services/report.service';

import {ActivatedRoute, Router} from '@angular/router';

import {FormBuilder} from '@angular/forms';

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
    console.log('Report List');
    this.reloadData();
  }

  reloadData(){
    this.reports = this.reportService.getAll();
    console.log(this.reports);
  }
  reportDetails(id: string){
    this.router.navigate(['reportDetails/' + id]);
  }

  updateReport(id: string){
    this.router.navigate(['updateReport/' + id]);
  }


}
