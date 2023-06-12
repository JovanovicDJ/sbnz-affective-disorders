import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiPaths } from 'src/environments/ApiPaths';
import { environment } from 'src/environments/environment';
import { Doctor } from '../../dto/Doctor';
import { Patient } from '../../dto/Patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http: HttpClient) {}

  getPatientsForDoctor(doctorID:number): Observable<Patient[]> {
    let url = `${environment.baseUrl}/${ApiPaths.PATIENTS}/forDoctor/${doctorID}`;
    return this.http.get<Patient[]>(url);
  }

  addNewPatient(patient :Patient){
    let url = `${environment.baseUrl}/${ApiPaths.REGISTER}/patient`;
    return this.http.post(url,patient);
  }

}
