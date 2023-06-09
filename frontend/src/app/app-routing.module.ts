import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PsyhopatyFormComponent } from './psyhopaty/psyhopaty-form/psyhopaty-form.component';

const routes: Routes = [
  {path:"psyhopaty" , component: PsyhopatyFormComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
