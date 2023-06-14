import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginData } from '../../dto/LoginData';
import { Doctor } from '../../dto/Doctor';
import { environment } from 'src/environments/environment';
import { ApiPaths } from 'src/environments/ApiPaths';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loggedUser: Doctor = {
    id: -1,
    name: '',
    surname: '',
    email: ''
  }

  constructor(private http: HttpClient) {}

  sendLoginRequest(data: LoginData): Observable<Doctor> {
    let url = `${environment.baseUrl}/${ApiPaths.LOGIN}`;
    return this.http.post<Doctor>(url, data);
  }

  setLoggedUser(user : Doctor){
    this.loggedUser = user;
  }

  logOutUser(){
    this.loggedUser = {
      id: -1,
      name: '',
      surname: '',
      email: ''
    };
  }
}
