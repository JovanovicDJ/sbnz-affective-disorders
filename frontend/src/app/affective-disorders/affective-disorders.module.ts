import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../shared/material/material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { AffectiveDisordersFormComponent } from './affective-disorders-form/affective-disorders-form.component';



@NgModule({
  declarations: [
    AffectiveDisordersFormComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    ReactiveFormsModule
  ]
})
export class AffectiveDisordersModule { }
