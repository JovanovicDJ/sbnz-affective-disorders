import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {
  BrowserAnimationsModule,
  NoopAnimationsModule,
} from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from './shared/material/material.module';
import { MatSliderModule } from '@angular/material/slider';
import { PsyhopatyModule } from './psyhopaty/psyhopaty.module';
import { AffectiveDisordersModule } from './affective-disorders/affective-disorders.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    BrowserAnimationsModule,
    SharedModule,
    FontAwesomeModule,
    FormsModule,
    HttpClientModule,
    PsyhopatyModule,
    AffectiveDisordersModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
