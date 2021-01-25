import { Component, OnInit } from '@angular/core';
import {Doctor} from '../../../classes/doctor';
import {Observable} from 'rxjs';
import {Tutorial} from '../../../classes/tutorial';
import {ActivatedRoute, Router} from '@angular/router';
import {TutorialService} from '../../../services/tutorial.service';
import {DoctorService} from '../../../services/doctor.service';

@Component({
  selector: 'app-doctor-details',
  templateUrl: './doctor-details.component.html',
  styleUrls: ['./doctor-details.component.css']
})
export class DoctorDetailsComponent implements OnInit {
  id: string;
  doctor: Doctor;

  constructor(private route: ActivatedRoute, private router: Router,
              private doctorService: DoctorService) { }

  ngOnInit(): void {
    this.doctor = new Doctor();

    this.id = this.route.snapshot.params['id'];

    this.doctorService.get(this.id)
      .subscribe(data => {
        console.log(data);
        this.doctor = data;
      }, error => console.log(error));
  }


  updateLink() {
    this.router.navigate(['DoctorUpdate', this.id]);
  }

  list() {
    this.router.navigate(['DoctorList']);

  }
}
