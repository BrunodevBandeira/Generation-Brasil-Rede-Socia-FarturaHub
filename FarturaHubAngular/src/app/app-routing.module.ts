import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HistoriaComponent } from './historia/historia.component';
import { InicioComponent } from './inicio/inicio.component';
import { MenuComponent } from './menu/menu.component';
import { PropositoComponent } from './proposito/proposito.component';
import { RodapeComponent } from './rodape/rodape.component';

const routes: Routes = [
  {path: "", redirectTo: "inicio", pathMatch: "full"},
  //Os componentes "menu" e "rodape" referem-se a página "início"
  {path: "inicio", component: InicioComponent},
  {path: "historia", component: HistoriaComponent},
  {path: "proposito", component: PropositoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
