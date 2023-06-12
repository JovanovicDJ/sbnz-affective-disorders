import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Subject, takeUntil } from 'rxjs';
import { Router } from '@angular/router';
import { MessageService, MessageType } from '../../services/message-service/message.service';
import { LoginService } from '../../services/login-service/login.service';
import { LoginData } from '../../dto/LoginData';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit, OnDestroy {
  destroy$: Subject<boolean> = new Subject<boolean>();
  form: FormGroup = this.createLoginForm();

  constructor(
    private messageService: MessageService,
    private loginService: LoginService,
    private router: Router
  ) {
  }

  ngOnDestroy(): void {
    this.destroy$.next(true);
    this.destroy$.unsubscribe();
  }
  ngOnInit(): void {}

  createLoginForm(): FormGroup {
    return new FormGroup({
      email: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });
  }

  login(){
    let loginData: LoginData = {
      email: this.form.get("email")?.value,
      password: this.form.get("password")?.value
    };
    this.loginService.sendLoginRequest(loginData).subscribe(
      {next: (data)=>{
        this.loginService.setLoggedUser(data);
        this.router.navigateByUrl('/doctor/homepage');
      },
      error: (data)=>{
        this.messageService.showMessage("Neispravni kredencijali",MessageType.ERROR);
      }
      }
    );
  }

}
