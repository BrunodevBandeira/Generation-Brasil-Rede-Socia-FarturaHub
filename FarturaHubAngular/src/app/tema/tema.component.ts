import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Tema } from 'src/app/model/Tema';
import { TemaService } from 'src/app/service/tema.service';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-tema',
  templateUrl: './tema.component.html',
  styleUrls: ['./tema.component.css']
})
export class TemaComponent implements OnInit {

  tema: Tema = new Tema()
  listaTemas: Tema[] //lista de temas

  constructor(
    private router: Router,
    private temaService: TemaService
  ) { }

  ngOnInit(){
    if(environment.token == ''){
      this.router.navigate(['/entrar'])
    }

    this.findAllTemas() // referente ao metodo abaixo
  }

  findAllTemas(){
    this.temaService.getAllTema().subscribe((resp: Tema[])=>{
      this.listaTemas = resp
    })
  }
  

  cadastrar(){
    this.temaService.postTema(this.tema).subscribe((resp:Tema)=>{
      this.tema=resp
      alert("Muito bem! O tema foi cadastrado com sucesso")
      this.findAllTemas() //Aqui serão mostrados todos os temas
      this.tema = new Tema() //Esta parte é responsáve por zerar o campo para gerar outro tema
    })
  }

}
