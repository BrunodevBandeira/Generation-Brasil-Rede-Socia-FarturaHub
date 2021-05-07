import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComponent } from './cadastro/cadastro.component';
import { TemaDeleteComponent } from './delete/tema-delete/tema-delete.component';
import { TemaEditComponent } from './edit/tema-edit/tema-edit.component';
import { HistoriaComponent } from './historia/historia.component';
import { InicioComponent } from './inicio/inicio.component';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { PostagensComponent } from './postagens/postagens.component';
import { PropositoComponent } from './proposito/proposito.component';
import { RodapeComponent } from './rodape/rodape.component';
import { TemaComponent } from './tema/tema.component';

const routes: Routes = [
  {path: "", redirectTo: "entrar", pathMatch: "full"},
  //Os componentes "menu" e "rodape" referem-se a página "início"
  {path: "inicio", component: InicioComponent},
  {path: "historia", component: HistoriaComponent},
  {path: "proposito", component: PropositoComponent},
  {path: "entrar", component: LoginComponent},
  {path: "cadastrar", component: CadastroComponent},
  {path: "tema", component: TemaComponent},
  //{path: "postagens", component: PostagensComponent},
  
  //Os parâmetros serão passados por essa rota
  {path: "tema-edit/:id", component: TemaEditComponent},
  {path: "tema-delete/:id", component: TemaDeleteComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
