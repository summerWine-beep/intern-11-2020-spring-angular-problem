import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, from, Subject} from 'rxjs';
import {Doctor} from '../classes/doctor';

const baseUrl = 'http://localhost:8080/api/doctors';


@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private subject = new Subject<any>();

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(baseUrl);
  }

  get(id: string): Observable<any> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data: object): Observable<object> {
    return this.http.post(baseUrl, data);
  }

  update(id: string, data: object): Observable<object> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  findByTitle(title: string): Observable<any> {
    return this.http.get(`${baseUrl}?title=${title}`);
  }

  getListUpdateAlert(): Observable<any> {
    return this.subject.asObservable();
  }

  findByName(name: any): Observable<Doctor[]> {
    return this.http.get<Doctor[]>(`${baseUrl}/name/${name}`);
  }
}
