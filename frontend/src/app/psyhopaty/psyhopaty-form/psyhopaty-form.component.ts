import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { PsyhopatyService } from '../services/psyhopaty.service';
import { LoginService } from 'src/app/shared/services/login-service/login.service';
import { Router } from '@angular/router';
import { Patient } from 'src/app/shared/dto/Patient';
import { PatientService } from 'src/app/shared/services/patient-service/patient.service';
import { AffectiveDisordersService } from 'src/app/affective-disorders/services/affective-disorders.service';
import { MessageService, MessageType } from 'src/app/shared/services/message-service/message.service';

@Component({
  selector: 'app-psyhopaty-form',
  templateUrl: './psyhopaty-form.component.html',
  styleUrls: ['./psyhopaty-form.component.css']
})
export class PsyhopatyFormComponent implements OnInit {

  step = 0;

  form : FormGroup = this.generateFormGroup();

  patients : Patient[] = [];
  

  constructor(
    private psyhopatyService: PsyhopatyService,
    private affectiveDisordersService:AffectiveDisordersService,
    private messageService:MessageService,
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

  setStep(index: number) {
    this.step = index;
  }

  nextStep() {
    this.step++;
  }

  prevStep() {
    this.step--;
  }

  sendForm() {
    const symptomList = Object.entries(this.form.getRawValue()).map(([name, intensity]) => ({ name, intensity }));
    console.log(symptomList);
    this.affectiveDisordersService
      .sendSymptoms(symptomList)
      .subscribe({
      next: (res: any) => {          
        console.log(res);
      },
      error: (err) => {
        this.messageService.showMessage(err.error.message, MessageType.ERROR);
      }
    });
  }

  generateFormGroup(): FormGroup {
    return new FormGroup({
      "need for stimulation": new FormControl(3),
      "parasitic lifesytle": new FormControl(3),
      "no long-term goals": new FormControl(3),
      "no ambition": new FormControl(3),
      "impulsiveness": new FormControl(3),
      "irresponsibility": new FormControl(3),
      
      "limited affect": new FormControl(3),
      "no empathy": new FormControl(3),
      "no responsibility": new FormControl(3),
      "no remorse": new FormControl(3),
      "no guilt": new FormControl(3),
      
      "grandiosity": new FormControl(3),
      "pathological lying": new FormControl(3),
      "manipulativeness": new FormControl(3),
      "artificial charm": new FormControl(3),
      
      "weak control": new FormControl(3),
      "early behavior problems": new FormControl(3),
      "juvenile delinquency": new FormControl(3),
      "criminal diversity": new FormControl(3),
    });
  }

}
