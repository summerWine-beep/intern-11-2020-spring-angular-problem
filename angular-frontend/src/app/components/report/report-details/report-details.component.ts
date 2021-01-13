import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Report} from "../../../classes/report";
import {ReportService} from "../../../services/report.service";

@Component({
  selector: 'app-report-details',
  templateUrl: './report-details.component.html',
  styleUrls: ['./report-details.component.css']
})
export class ReportDetailsComponent implements OnInit {

  id: string;
  reports: Report;

  constructor(private route: ActivatedRoute, private router: Router,
              private reportService: ReportService) { }

  ngOnInit(): void {
    this.reports = new Report();
    this.id = this.route.snapshot.params.id ;

    this.reportService.get(this.id)
      .subscribe(data => {
        console.log(data);
        this.reports = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['reports']);
  }
  updateReports(){
    this.router.navigate(['updateReport/' + this.reports.id]);
  }

}
