import { Component } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {subscribeOn} from "rxjs/operators";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-frontend';
  constructor(private http:HttpClient) {
  }


}
