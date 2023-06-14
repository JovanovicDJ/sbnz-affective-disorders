import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from './material/material.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { MessageComponent } from './services/message-service/message.service';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HomepageComponent } from './components/homepage/homepage.component';
import { NewPatientComponent } from './components/new-patient/new-patient.component';
import { PatientPickerComponent } from './components/patient-picker/patient-picker.component';


@NgModule({
  declarations: [
    MessageComponent,
    NavbarComponent,
    LoginComponent,
    HomepageComponent,
    NewPatientComponent,
    PatientPickerComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FontAwesomeModule,
    ReactiveFormsModule
  ],
  exports: [
    MaterialModule,
    NavbarComponent,
    PatientPickerComponent
  ]
})
export class SharedModule { }
