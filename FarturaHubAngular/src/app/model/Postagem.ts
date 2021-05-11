import { User } from "./User";
import  { Tema } from "./Tema";

export class Postagem{
    public id: number
    public titulo: string
    public descricao: string
    public data: Date
    public contato: string      //telefone, e-mail
    public usuario: User        //não havíamos feito as linhas 10 e 11, agora está OKAY
    public tema: Tema
    //public regiao: string
    //public ajudado: boolean
    //public nomeAjudante: string  
}
