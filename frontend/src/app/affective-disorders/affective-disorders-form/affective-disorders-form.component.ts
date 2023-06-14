import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { generate } from 'rxjs';
import { AffectiveDisordersService } from '../services/affective-disorders.service';
import { MessageService, MessageType } from 'src/app/shared/services/message-service/message.service';
import { LoginService } from 'src/app/shared/services/login-service/login.service';
import { Router } from '@angular/router';
import { PatientService } from 'src/app/shared/services/patient-service/patient.service';
import { Patient } from 'src/app/shared/dto/Patient';

@Component({
  selector: 'app-affective-disorders-form',
  templateUrl: './affective-disorders-form.component.html',
  styleUrls: ['./affective-disorders-form.component.css']
})
export class AffectiveDisordersFormComponent implements OnInit {
  step = 0;

  form : FormGroup = this.generateFormGroup();

  patients : Patient[] = [];

  patientId: number = -1;
  showSpiner :boolean = false;

  constructor(private affectiveDisordersService: AffectiveDisordersService,
              private messageService: MessageService,
              private userService: LoginService,
              private router: Router,
              private patientService: PatientService) { }

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

  patientChanged(selectedPatient: Patient) {
    this.patientId = selectedPatient.id;
  }

  sendForm() {
    if (this.patientId === -1) {
      this.messageService.showMessage('Pacijent nije odabran!', MessageType.WARNING);
    } else {
      this.showSpiner = true;
      const symptomList = Object.entries(this.form.getRawValue()).map(([name, intensity]) => ({ name, intensity, patientId: this.patientId }));
      this.affectiveDisordersService
        .sendSymptoms(symptomList)
        .subscribe({
        next: (res: any) => {   
          this.showSpiner = false;       
          if (res.message === '') {
            this.messageService.showMessage('Pacijent nema nijedan poremećaj!', MessageType.INFO);
          } else {
            this.messageService.showMessage(res.message, MessageType.SUCCESS);
          }
          this.router.navigateByUrl("patient/history/"+this.patientId);
        },
        error: (err) => {
          this.messageService.showMessage(err.error.message, MessageType.ERROR);
        }
      });
    }
  }

  generateFormGroup(): FormGroup {
    return new FormGroup({
      "low affect": new FormControl(3),
      "anhedonia": new FormControl(3),
      "tension": new FormControl(3),
      "unrest": new FormControl(3),
      "concern": new FormControl(3),
      "fear of losing control": new FormControl(3),
      "emptiness": new FormControl(3),
      "guilt": new FormControl(3),
      "sinfulness": new FormControl(3),
      "perdition": new FormControl(3),
      "euphoria": new FormControl(3),
      "irritability": new FormControl(3),
      "expansiveness": new FormControl(3),

      "pessimism": new FormControl(3),
      "low concentration": new FormControl(3),
      "hopelessness": new FormControl(3),
      "worthlessness": new FormControl(3),
      "suicidal ideation": new FormControl(3),
      "nihilistic": new FormControl(3),
      "talkative": new FormControl(3),
      "grandiose ideas": new FormControl(3),
      "hyperoptimism": new FormControl(3),
      "distractibility": new FormControl(3),

      "disturbed sleep": new FormControl(3),
      "no sleep": new FormControl(3),
      "low energy level": new FormControl(3),
      "increased energy": new FormControl(3),
      "disturbed appetite": new FormControl(3),
      "appetite increase": new FormControl(3),
      "loss of libido": new FormControl(3),
      "hypochondriacal": new FormControl(3),
      "in pregnancy": new FormControl(1),
      "after pregnancy": new FormControl(1),

      "negligence": new FormControl(3),
      "loss of interest": new FormControl(3),
      "loss of emotional reactivity to positive dearer": new FormControl(3),
      "mood reactivity": new FormControl(3),
      "sensitivity to interpersonal rejection": new FormControl(3),
      "excessive activity": new FormControl(3),
      "impulsiveness": new FormControl(3),
      "aggressiveness": new FormControl(3),
      "disinhibition": new FormControl(3),

      "duration": new FormControl(1)
    });
  }
  

}
