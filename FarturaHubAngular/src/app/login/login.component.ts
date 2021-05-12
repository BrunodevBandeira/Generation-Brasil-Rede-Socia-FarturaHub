
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { User } from '../model/User';
import { UserLogin } from '../model/UserLogin';
import { AlertasService } from '../service/alertas.service';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userLogin:UserLogin=new UserLogin()

  constructor(
    private auth: AuthService,
    private router: Router,
    private alertas: AlertasService
    ) {
    }

  ngOnInit(){
    window.scroll(0,0)
  }

  entrar(){
    //subscribe p/ criar um JSON
    this.auth.login(this.userLogin).subscribe((resp: UserLogin) =>{
      this.userLogin = resp
     
      environment.token = this.userLogin.token
      environment.nomeCompleto = this.userLogin.nomeCompleto
      environment.id = this.userLogin.id
      environment.foto = this.userLogin.foto

      console.log(environment.token)
      console.log(environment.nomeCompleto)
      console.log(environment.foto)
      console.log(environment.id)

      this.router.navigate(["/inicio"])

      
  }, erro=>{
    if(erro.status==500){
      this.alertas.showAlertDanger ('usuário ou senha estão incorretos')
    }
  })
  
  
  
}
}