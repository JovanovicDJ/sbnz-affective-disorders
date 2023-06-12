import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PsyhopatyFormComponent } from './psyhopaty-form/psyhopaty-form.component';
import { MatSliderModule } from '@angular/material/slider';
import { MaterialModule } from '../shared/material/material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';



@NgModule({
  declarations: [
    PsyhopatyFormComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    ReactiveFormsModule,
    SharedModule
  ]
})
export class PsyhopatyModule { }
