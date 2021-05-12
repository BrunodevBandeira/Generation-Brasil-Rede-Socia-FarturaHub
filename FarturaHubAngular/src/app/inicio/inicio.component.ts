import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { AlertasComponent } from '../alertas/alertas.component';
import { Postagem } from '../model/Postagem';
import { Tema } from '../model/Tema';
import { User } from '../model/User';
import { AlertasService } from '../service/alertas.service';
import { AuthService } from '../service/auth.service';
import { InicioService } from '../service/inicio.service';
import { TemaService } from '../service/tema.service';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  postagem: Postagem = new Postagem()

  tema: Tema = new Tema()
  listaPostagens: Postagem[]
  listaTemas: Tema[]
  idTema: number
  tituloPost: string


  user: User = new User()
  idUser = environment.id

  key = 'data'
  reverse = true
  postagemService: any;

  constructor(
    private router: Router,
    private inicioService: InicioService, //inicio == postagem
    private temaService: TemaService,
    private authService: AuthService,
    private alertas: AlertasService
  ) { }

  ngOnInit() {
    window.scroll(0, 0)
    if (environment.token == "") {
      //alert("Sua sessão expirou. Faça o login")
      this.router.navigate(["/entrar"])
    }
    this.getAllTemas()
    this.getAllPostagens()  //trará todos os temas ao iniciar
  }

  getAllTemas() {
    this.temaService.getAllTema().subscribe((resp: Tema[]) => {
      this.listaTemas = resp
    })
  }

  findByIdTema() {
    this.temaService.getByIdTema(this.idTema).subscribe((resp: Tema) => {
      this.tema = resp
    })
  }

  getAllPostagens() {
    this.inicioService.getAllPostagens().subscribe((resp: Postagem[]) => {
      this.listaPostagens = resp
    })
  }

  findByIdUser() {
    this.authService.getByIdUser(this.idUser).subscribe((resp: User) => {
      this.user = resp
    })
  }

  publicar() {
    this.tema.id = this.idTema
    this.postagem.tema = this.tema

    this.user.id = this.idUser  //receberá o ID de quem está logado
    this.postagem.usuario = this.user

    this.inicioService.postPostagem(this.postagem).subscribe((resp: Postagem) => {
      this.postagem = resp
      this.alertas.showAlertSuccess("Sua postagem foi feita com sucesso")
      this.postagem = new Postagem
      this.getAllPostagens()
    })

  }

  findByTituloPostagem() {

    if (this.tituloPost == '') {
      this.getAllPostagens()
    } else {
      this.postagemService.getByTituloPostagem(this.tituloPost).subscribe((resp: Postagem[]) => {
        this.listaPostagens = resp
      })
    }

  }

}
