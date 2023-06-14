import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from 'src/app/shared/dto/Patient';
import { ApiPaths } from 'src/environments/ApiPaths';
import { environment } from 'src/environments/environment';
import { HistoryData } from '../dto/historyData';

@Injectable({
  providedIn: 'root'
})
export class HistoryService {

  constructor(private http: HttpClient) {}

  getHistoryForPatient(patient:Patient):Observable<HistoryData[]> {
    return this.http.get<HistoryData[]>(`${environment.baseUrl}/${ApiPaths.PATIENTS}/${ApiPaths.HISTORY}/${patient.id}`);
  }
}
