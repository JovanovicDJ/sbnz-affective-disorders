import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PsyhopatyTestDTO } from 'src/app/shared/dto/PsyhoTestDTO';
import { ApiPaths } from 'src/environments/ApiPaths';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PsyhopatyService {

  url: string = `${environment.baseUrl}/${ApiPaths.PSYHOPATY}`;

  constructor(private http: HttpClient) {}

  addNewPatientTest(psyhopatyTest : PsyhopatyTestDTO){
    return this.http.post(this.url, psyhopatyTest);
  }
}
