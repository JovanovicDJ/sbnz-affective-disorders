import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Patient } from '../../dto/Patient';
import { LoginService } from '../../services/login-service/login.service';
import { PatientService } from '../../services/patient-service/patient.service';
import { MatDialogRef } from '@angular/material/dialog';
import { MessageService, MessageType } from '../../services/message-service/message.service';

@Component({
  selector: 'app-new-patient',
  templateUrl: './new-patient.component.html',
  styleUrls: ['./new-patient.component.css']
})
export class NewPatientComponent implements OnInit {

  form : FormGroup = new FormGroup({
    name: new FormControl(),
    surname : new FormControl(),
    email : new FormControl(),
    phoneNum: new FormControl(),
    dob: new FormControl(),
    gender: new FormControl()
  });

  constructor(
    private userService : LoginService,
    private patientService: PatientService,
    private messageService: MessageService,
    public dialogRef: MatDialogRef<NewPatientComponent>,

  ) { }

  ngOnInit(): void {
  }

  addNewPatient(){

    let date =this.form.get('dob')?.value; 
    let newPatient: Patient = {
      id: -1,
      doctorID: this.userService.loggedUser.id,
      name: this.form.get('name')?.value,
      surname: this.form.get('surname')?.value,
      email: this.form.get('email')?.value,
      phoneNum: this.form.get('phoneNum')?.value,
      dob:  date.getFullYear()+"-"+this.formatDateNum(date.getMonth()+1)+"-"+this.formatDateNum(date.getDate()),
      gender: this.form.get('gender')?.value
    };
    // console.log(newPatient);
    this.patientService.addNewPatient(newPatient).subscribe(
      data => {
        this.messageService.showMessage("Dodat novi pacijent",MessageType.SUCCESS);
        this.dialogRef.close();
      }
    );
  }

  formatDateNum(dateNum:number):string{
    if(dateNum >= 10)
      return dateNum+"";
    return "0"+dateNum;
  }

}
