package org.example.entidades


import org.example.enumeradores.Setor
import org.example.enumeradores.Sexo

class Funcionario (
    nome: String = "",
    sexo : Sexo,
    cpf: Long,
    idade: Int,
    val setor : Setor
) : Pessoa(
    nome = nome,
    sexo = Sexo.MASCULINO,
    cpf = cpf,
    idade = idade,
){
    //Comportamentos do Profissional
    fun instalarCaixaDAgua(clt : Funcionario){
        if (clt.setor.equals(Setor.MONTAGEM)){
            println("Profissional Habilitado")
        }else{
            println("Profissional desqualificado")
        }
    }
}