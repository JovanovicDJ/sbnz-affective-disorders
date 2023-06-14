import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Patient } from 'src/app/shared/dto/Patient';
import { PsyhopatyTestDTO } from 'src/app/shared/dto/PsyhoTestDTO';
import { ApiPaths } from 'src/environments/ApiPaths';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PsyhopatyService {

  url: string = `${environment.baseUrl}/${ApiPaths.PSYHOPATY}`;

  constructor(private http: HttpClient) {}

  sendSymptoms(symptoms: Array<Object>) {
    return this.http.post(`${environment.baseUrl}/${ApiPaths.SYMPTOMS}/psycho`, symptoms);
  }
}
