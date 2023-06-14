import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PsyhopatyFormComponent } from './psyhopaty/psyhopaty-form/psyhopaty-form.component';
import { LoginComponent } from './shared/components/login/login.component';
import { HomepageComponent } from './shared/components/homepage/homepage.component';
import { AffectiveDisordersFormComponent } from './affective-disorders/affective-disorders-form/affective-disorders-form.component';
import { HistoryComponent } from './history/components/history/history.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'doctor/homepage', component: HomepageComponent },
  { path: 'doctor/psyhotest', component: PsyhopatyFormComponent },
  { path: 'patient/history/:id', component: HistoryComponent },
  {
    path: 'doctor/affective-disorders',
    component: AffectiveDisordersFormComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
