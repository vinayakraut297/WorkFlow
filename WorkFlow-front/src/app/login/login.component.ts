import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpService } from '../http.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private service:HttpService,
     private router:Router
  ){}

  EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
  + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

  PASSWORD_PATTERN = /^(?=.[A-Za-z])(?=.\d)[A-Za-z\d]{6,}$/;

  backendResponse:string=''       

    onSubmit(loginForm:NgForm){
      
         this.service.login(loginForm.value)
         .subscribe((response:any)=>{
          console.log(response);
              if(response.message=='Login Successful'){
                 //alert("Login success")

                 sessionStorage.setItem("username",response.user.firstName);
                  this.router.navigate(['/home']);
              }
              else{
                     this.backendResponse=response.message;
              }
         })
    }
}
