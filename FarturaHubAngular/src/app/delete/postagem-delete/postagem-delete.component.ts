import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Postagem } from 'src/app/model/Postagem';
import { InicioService } from 'src/app/service/inicio.service';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-postagem-delete',
  templateUrl: './postagem-delete.component.html',
  styleUrls: ['./postagem-delete.component.css']
})
export class PostagemDeleteComponent implements OnInit {

  postagem: Postagem = new Postagem()
  idPostagem: number

  constructor(
    private inicioService: InicioService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(){
    if(environment.token==""){
      this.router.navigate(["/entrar"])
    }

    this.idPostagem = this.route.snapshot.params["id"]
    this.getByIdPostagem(this.idPostagem) 

  }

  getByIdPostagem(id: number){
    this.inicioService.getByIdPostagem(id).subscribe((resp: Postagem)=> {
      this.postagem = resp
    })
  }

  apagar(){         
    this.inicioService.deletePostagem(this.idPostagem).subscribe(()=>{
      alert("O tema foi apagado")
      this.router.navigate(["/inicio"])
    })
  }

}
