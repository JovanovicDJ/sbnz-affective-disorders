import { Component, OnInit, ViewChild } from '@angular/core';
import { HistoryService } from '../../services/history.service';
import { MessageService } from 'src/app/shared/services/message-service/message.service';
import { LoginService } from 'src/app/shared/services/login-service/login.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/shared/dto/Patient';
import { PatientService } from 'src/app/shared/services/patient-service/patient.service';
import { HistoryData } from '../../dto/historyData';
import { PatientPickerComponent } from 'src/app/shared/components/patient-picker/patient-picker.component';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  patients : Patient[] = [];
  patient : Patient ={
    id: -1,
    doctorID: 0,
    name: '',
    surname: '',
    email: '',
    phoneNum: '',
    dob: '',
    gender: ''
  }

  historicData: HistoryData[] = [];

  routeID :number = 0;


  displayedColumns: string[] = [
    'name',
    'date',
  ];

  @ViewChild(PatientPickerComponent) patientPicker! : PatientPickerComponent;

  constructor(
    private messageService:MessageService,
    private userService: LoginService,
    private router : Router,
    private historyService: HistoryService,
    private patientService:PatientService,
    private _Activatedroute:ActivatedRoute
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
        this._Activatedroute.paramMap.subscribe(paramMap => { 
          this.routeID = +paramMap.get('id')!; 
        });
        this.patientPicker.selectPatient();
      }
    )
  }

  patientChanged(selectedPatient:Patient){
    this.patient = selectedPatient;
    this.historyService.getHistoryForPatient(this.patient).subscribe(
      data => {
        this.historicData = data;
      }
    )
  }
}
