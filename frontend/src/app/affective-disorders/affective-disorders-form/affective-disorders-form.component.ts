import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { generate } from 'rxjs';
import { AffectiveDisordersService } from '../services/affective-disorders.service';
import { MessageService, MessageType } from 'src/app/shared/services/message-service/message.service';

@Component({
  selector: 'app-affective-disorders-form',
  templateUrl: './affective-disorders-form.component.html',
  styleUrls: ['./affective-disorders-form.component.css']
})
export class AffectiveDisordersFormComponent implements OnInit {
  step = 0;

  form : FormGroup = this.generateFormGroup();

  constructor(private affectiveDisordersService: AffectiveDisordersService,
              private messageService: MessageService) { }

  ngOnInit(): void {
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
    const symptomList = Object.entries(this.form.getRawValue()).map(([name, intensity]) => ({ name, intensity, patientId: 1 }));
    //console.log(symptomList);
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
