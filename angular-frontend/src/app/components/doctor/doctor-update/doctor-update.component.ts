import { Component, OnInit } from '@angular/core';
import {Doctor} from "../../../classes/doctor";
import {ActivatedRoute, Router} from "@angular/router";
import {DoctorService} from "../../../services/doctor.service";

@Component({
  selector: 'app-doctor-update',
  templateUrl: './doctor-update.component.html',
  styleUrls: ['./doctor-update.component.css']
})
export class DoctorUpdateComponent implements OnInit {

  id: string;
  doctor: Doctor;

  constructor(private route: ActivatedRoute, private router: Router,
              private doctorService: DoctorService) { }

  ngOnInit() {
    this.doctor = new Doctor();

    this.id = this.route.snapshot.params['id'];

    this.doctorService.get(this.id)
      .subscribe(data => {
        console.log(data);
        this.doctor = data;
      }, error => console.log(error));
  }

  updateDoctor(){
    this.doctorService.update(this.id, this.doctor).subscribe(
      data => {
        console.log(data);
        this.doctor = new Doctor();
        this.list();
      }, error => console.log(error)
    );
  }

  onSubmit(){
    this.updateDoctor();
  }

  list(){
    this.router.navigate(['doctors']);
  }

}
