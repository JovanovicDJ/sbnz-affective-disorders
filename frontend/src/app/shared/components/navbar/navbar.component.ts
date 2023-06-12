import { Component, OnInit } from '@angular/core';
import { MessageService, MessageType } from '../../services/message-service/message.service';
import { LoginService } from '../../services/login-service/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(
    private messageService: MessageService,
    public loginService:LoginService,
    private router:Router
  ) { }

  ngOnInit(): void {
  }


  logout(){
    this.loginService.logOutUser();
    this.router.navigateByUrl('');

  }
}
