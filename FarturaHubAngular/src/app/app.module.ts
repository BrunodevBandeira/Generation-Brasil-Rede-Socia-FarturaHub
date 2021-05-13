import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { RodapeComponent } from './rodape/rodape.component';
import { HistoriaComponent } from './historia/historia.component';
import { PropositoComponent } from './proposito/proposito.component';
import { InicioComponent } from './inicio/inicio.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { LoginComponent } from './login/login.component';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { TemaComponent } from './tema/tema.component';
import { TemaDeleteComponent } from './delete/tema-delete/tema-delete.component';
import { TemaEditComponent } from './edit/tema-edit/tema-edit.component';
import { PostagensComponent } from './postagens/postagens.component';

import { PostagemEditComponent } from './edit/postagem-edit/postagem-edit.component';
import { PostagemDeleteComponent } from './delete/postagem-delete/postagem-delete.component';
import { AlertasComponent } from './alertas/alertas.component';
import { ModalModule } from 'ngx-bootstrap/modal';


import { SobreNosComponent } from './sobre-nos/sobre-nos.component';
import { OrderModule } from 'ngx-order-pipe';
/* >>>>>>> 15886d95bfe767e46c96e8c618f0f212468e1ac6 */

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    RodapeComponent,
    HistoriaComponent,
    PropositoComponent,
    InicioComponent,
    CadastroComponent,
    LoginComponent,
    TemaComponent,
    TemaDeleteComponent,
    TemaEditComponent,
    PostagensComponent,
    PostagemEditComponent,
    PostagemDeleteComponent,
    AlertasComponent,
    SobreNosComponent
/* ======= */
    
/* >>>>>>> 15886d95bfe767e46c96e8c618f0f212468e1ac6 */
  ],
    imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ModalModule.forRoot(),
    OrderModule
    
  ],
  providers: [{   //para evitar que o Angular "se perca" nas rotas
    provide: LocationStrategy,
    useClass: HashLocationStrategy
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
