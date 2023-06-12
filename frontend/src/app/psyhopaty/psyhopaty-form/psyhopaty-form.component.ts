import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { PsyhopatyService } from '../services/psyhopaty.service';
import { LoginService } from 'src/app/shared/services/login-service/login.service';
import { Router } from '@angular/router';
import { Patient } from 'src/app/shared/dto/Patient';
import { PatientService } from 'src/app/shared/services/patient-service/patient.service';

@Component({
  selector: 'app-psyhopaty-form',
  templateUrl: './psyhopaty-form.component.html',
  styleUrls: ['./psyhopaty-form.component.css']
})
export class PsyhopatyFormComponent implements OnInit {

  patients : Patient[] = [];
  
  form : FormGroup = new FormGroup({
    INTERPERSONAL_FACTOR: new FormControl(3),
    AFFECTIVE_FACTOR: new FormControl(3),
    LIFESTYLE_FACTOR: new FormControl(3),
    ANTISOCIAL_FACTOR: new FormControl(3)    
  });

  constructor(
    private psyhopatyService: PsyhopatyService,
    private userService: LoginService,
    private router : Router,
    private patientService: PatientService
  ) { }

  ngOnInit(): void {
    if(this.userService.loggedUser.id == -1){
      this.router.navigateByUrl("");
    }
    this.refreshData();
  }

  refreshData(){

    this.patientService.getPatientsForDoctor(this.userService.loggedUser.id).subscribe(
      data => {
        this.patients = data;
      }
    )
  }

  submit(){
    console.log(this.form.getRawValue());
    //make DTO 
    // this.psyhopatyService.addNewPatientTest();
  }

}
