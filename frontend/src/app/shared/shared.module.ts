import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from './material/material.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { MessageComponent } from './services/message-service/message.service';
import { NavbarComponent } from './components/navbar/navbar.component';


@NgModule({
  declarations: [
    MessageComponent,
    NavbarComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FontAwesomeModule
  ],
  exports: [
    MaterialModule,
    NavbarComponent
  ]
})
export class SharedModule { }
