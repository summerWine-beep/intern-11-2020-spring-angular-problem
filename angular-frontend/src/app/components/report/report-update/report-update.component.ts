import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Report} from '../../../classes/report';
import {ReportService} from '../../../services/report.service';

@Component({
  selector: 'app-report-update',
  templateUrl: './report-update.component.html',
  styleUrls: ['./report-update.component.css']
})
export class ReportUpdateComponent implements OnInit {

  id: string;
  report: Report;

  constructor(private route: ActivatedRoute, private router: Router,
              private reportService: ReportService) { }

  ngOnInit() {
    this.report = new Report();

    this.id = this.route.snapshot.params.id;

    this.reportService.get(this.id)
      .subscribe(data => {
        console.log(data);
        this.report = data;
      }, error => console.log(error));
  }

  updateReport(){
    this.reportService.update(this.id, this.report).subscribe(
      data => {
        console.log(data);
        this.report = new Report();
        this.list();
      }, error => console.log(error)
    );
  }

  onSubmit(){
    this.updateReport();
  }

  list(){
    this.router.navigate(['/reports']);
  }

}
