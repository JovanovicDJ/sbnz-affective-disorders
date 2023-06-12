import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApiPaths } from 'src/environments/ApiPaths';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AffectiveDisordersService {

  constructor(private http: HttpClient) { }

  sendSymptoms(symptoms: Array<Object>) {
    return this.http.post(`${environment.baseUrl}/${ApiPaths.SYMPTOMS}`, symptoms);
  }
}
