import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { PsyhopatyService } from '../services/psyhopaty.service';

@Component({
  selector: 'app-psyhopaty-form',
  templateUrl: './psyhopaty-form.component.html',
  styleUrls: ['./psyhopaty-form.component.css']
})
export class PsyhopatyFormComponent implements OnInit {

  form : FormGroup = new FormGroup({
    INTERPERSONAL_FACTOR: new FormControl(3),
    AFFECTIVE_FACTOR: new FormControl(3),
    LIFESTYLE_FACTOR: new FormControl(3),
    ANTISOCIAL_FACTOR: new FormControl(3)    
  });

  constructor(
    private psyhopatyService: PsyhopatyService
  ) { }

  ngOnInit(): void {
  }

  submit(){
    console.log(this.form.getRawValue());
    //make DTO 
    // this.psyhopatyService.addNewPatientTest();
  }

}
