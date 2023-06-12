import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Patient } from '../../dto/Patient';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-patient-picker',
  templateUrl: './patient-picker.component.html',
  styleUrls: ['./patient-picker.component.css']
})
export class PatientPickerComponent implements OnInit {

  selectedPatient : Patient = {
    id: 0,
    doctorID: 0,
    name: '',
    surname: '',
    email: '',
    phoneNum: '',
    dob: '',
    gender: ''
  }

  // form : FormGroup = new FormGroup({
  //   name: new FormControl(),
  //   surname : new FormControl(),
  //   email : new FormControl(),
  //   phoneNum: new FormControl(),
  //   dob: new FormControl(),
  //   gender: new FormControl()
  // });
  
  @Input() patients : Patient[] = [];

  @Output() patientChanged : EventEmitter<Patient> = new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }

  selectedPatientChanged(){
    // this.form.get('name')?.setValue(this.selectedPatient.name);
    // this.form.get('surname')?.setValue(this.selectedPatient.surname);
    // this.form.get('email')?.setValue(this.selectedPatient.email);
    // this.form.get('phoneNum')?.setValue(this.selectedPatient.phoneNum);
    // this.form.get('dob')?.setValue(this.selectedPatient.dob);
    this.patientChanged.emit(this.selectedPatient);
  }
}
