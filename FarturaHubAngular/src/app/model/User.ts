import { Postagem } from "./Postagem";
export class User{
        public cpfCnpj: string
        public nomeCompleto: string
        public email: string
        public senha: string
        public foto: string
        public id: number
        public postagem:Postagem[]
    }

    