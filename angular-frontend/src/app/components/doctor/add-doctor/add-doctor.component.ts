import { Component, OnInit } from '@angular/core';
import {Observable, observable} from 'rxjs';
import { Doctor } from '../../../classes/doctor';
import {DoctorService} from '../../../services/doctor.service';
import {Router} from '@angular/router';
import {observableToBeFn} from "rxjs/internal/testing/TestScheduler";



@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})


export class AddDoctorComponent implements OnInit {

  doctor: Observable<Doctor[]>;
  submitted = false;


  constructor(private doctorService: DoctorService, private router: Router) { }

  ngOnInit(): void {
  }

}
