import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../../../services/doctor.service';
import {Observable} from 'rxjs';
import { Router } from '@angular/router';
import { Doctor } from '../../../classes/doctor';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent implements OnInit {
  doctors: Observable<Doctor[]>;
  constructor(private doctorService: DoctorService, private route: Router) { }

  ngOnInit(): void {
    this.doctors = this.doctorService.getAll();
    console.log(this.doctors);

  }

}
