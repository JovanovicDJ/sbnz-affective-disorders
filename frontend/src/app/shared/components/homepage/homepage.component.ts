import { Component, OnInit } from '@angular/core';
import { Patient } from '../../dto/Patient';
import { PatientService } from '../../services/patient-service/patient.service';
import { LoginService } from '../../services/login-service/login.service';
import { Router } from '@angular/router';
import { NewPatientComponent } from '../new-patient/new-patient.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
})
export class HomepageComponent implements OnInit {
  patients: Patient[] = [];

  displayedColumns: string[] = ['name', 'surname', 'email', 'phoneNum'];

  constructor(
    private patientService: PatientService,
    private userService: LoginService,
    private router: Router,
    private matDialog: MatDialog
  ) {}

  ngOnInit(): void {
    if (this.userService.loggedUser.id == -1) {
      this.router.navigateByUrl('');
    }
    this.refreshData();
  }

  refreshData() {
    this.patientService
      .getPatientsForDoctor(this.userService.loggedUser.id)
      .subscribe((data) => {
        this.patients = data;
      });
  }

  addNewPatient() {
    const dialogRef = this.matDialog.open(NewPatientComponent);
    dialogRef.afterClosed().subscribe((result) => {
      this.refreshData();
    });
  }

  newPsyhopatyTest() {
    this.router.navigateByUrl('doctor/psyhotest');
  }

  newAffectiveDisordersTest() {
    this.router.navigateByUrl("doctor/affective-disorders");
  }

  openHistoryForPatient(patientID:number){
    this.router.navigateByUrl(`patient/history/${patientID}`);  
  }
}
