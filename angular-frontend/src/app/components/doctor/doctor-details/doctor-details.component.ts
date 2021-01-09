import { Component, OnInit } from '@angular/core';
import {Doctor} from '../../../classes/doctor';
import {ActivatedRoute, Router} from '@angular/router';
import {DoctorService} from '../../../services/doctor.service';

@Component({
  selector: 'app-doctor-details',
  templateUrl: './doctor-details.component.html',
  styleUrls: ['./doctor-details.component.css']
})
export class DoctorDetailsComponent implements OnInit {
  id: string;
  doctors: Doctor;

  constructor(private route: ActivatedRoute, private router: Router,
              private doctorService: DoctorService) { }

  ngOnInit(): void {
    this.doctors = new Doctor();
    this.id = this.route.snapshot.params.id ;

    this.doctorService.get(this.id)
      .subscribe(data => {
        console.log(data);
        this.doctors = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['doctors']);
  }
  updateDoctors(){
    this.router.navigate(['updateDoctor/' + this.doctors.id]);
  }

}
