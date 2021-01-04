import { Component, OnInit } from '@angular/core';
import { PatientService} from "../../../services/patient.service";
import {Router} from "@angular/router";
import { Patient } from '../../../classes/patient';


@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {
  constructor() {}

  ngOnInit() {}

  addPatient(event){
    // event.preventDefault()
    // const target = event.target
    // const patient_name = target.querySelector('#patient_name').value
    // const date_of_birth = target.querySelector('#date_of_birth').value
    // const age = target.querySelector('#age').value
    // const Gender = target.querySelector('#Gender').value
    // const occupation = target.querySelector('#occupation').value
    // const health_insurance_no = target.querySelector('#health_insurance_no').value
    // const health_care_provider = target.querySelector('#health_care_provider').value
    // const patient_address = target.querySelector('#patient_address').value
    // const contact_no = target.querySelector('#contact_no').value
    // const doctor_id = target.querySelector('#doctor_id').value
    event.preventDefault()
    console.log(event)


  }

}
