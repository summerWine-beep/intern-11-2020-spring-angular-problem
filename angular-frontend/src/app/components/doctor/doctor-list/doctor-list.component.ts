import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Doctor} from '../../../classes/doctor';
import {DoctorService} from '../../../services/doctor.service';
import {Router} from '@angular/router';
import {FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent implements OnInit {

  doctors: Observable<Doctor[]>;
  searchForm;
  constructor(private doctorServices: DoctorService, private router: Router, private formBuilder: FormBuilder) {
    this.searchForm = this.formBuilder.group({
      name: '',
    });
  }

  ngOnInit(): void {
    console.log('Doctor List');
    this.reloadData();
  }

  reloadData(){
    this.doctors = this.doctorServices.getAll();
    console.log(this.doctors);
  }

  deleteDoctor(id: string) {
    this.doctorServices.delete(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
doctorDetails(id: string){
    this.router.navigate(['doctorDetails/' + id]);
  }

  updateDoctor(id: string){
    this.router.navigate(['updateDoctor/' + id]);
  }

  OnSubmit(searchName){
    console.log('Search Doctor Name:');
    console.log(searchName.doctorName);
    this.doctors = this.doctorServices.findByDoctorName(searchName.doctorName);
  }

}
