import { Component, OnInit } from '@angular/core';
import {Doctor} from '../../../classes/doctor';
import {ActivatedRoute, Router} from "@angular/router";
import {DoctorService} from "../../../services/doctor.service";
import {Tutorial} from "../../../classes/tutorial";

@Component({
  selector: 'app-doctor-details',
  templateUrl: './doctor-details.component.html',
  styleUrls: ['./doctor-details.component.css']
})
export class DoctorDetailsComponent implements OnInit {
  id: string;
  doctor: Doctor;

  constructor(private route: ActivatedRoute, private router: Router, private doctorService: DoctorService) { }

  ngOnInit() {
    this.doctor = new Doctor();

    this.id = this.route.snapshot.params.id;

    this.doctorService.get(this.id)
      .subscribe(data => {
        console.log(data);
        this.doctor = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['doctors']);
  }
  updateLink(){
    this.router.navigate(['update/' + this.doctor.id]);
  }

}
