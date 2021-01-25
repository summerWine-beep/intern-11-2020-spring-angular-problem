import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {DoctorService} from '../../../services/doctor.service';
import {Tutorial} from '../../../classes/tutorial';
import {Doctor} from '../../../classes/doctor';

@Component({
  selector: 'app-doctor-update',
  templateUrl: './doctor-update.component.html',
  styleUrls: ['./doctor-update.component.css']
})
export class DoctorUpdateComponent implements OnInit {
  private id: string;
  doctor: Doctor = new Doctor();


  constructor(private route: ActivatedRoute, private doctorService: DoctorService,
              private router: Router) {
  }


    ngOnInit() {
      this.id = this.route.snapshot.params['id'];

      this.doctorService.get(this.id)
        .subscribe(data => {
          console.log(data);
          this.doctor = data;
        }, error => console.log(error));
    }

  updatedoctor(){
    this.doctorService.update(this.id, this.doctor).subscribe(
      data => {
        console.log(data);
        this.doctor = new Doctor();
        this.list();
      }, error => console.log(error)
    );
  }

  onSubmit(){
    this.updatedoctor();
  }

  list() {
    this.router.navigate(['DoctorList']);
  }
}
