package org.example.entidades


import org.example.enumeradores.Sexo

class Cliente (
    nome : String,
    idade : Int,
    cpf : Long,
    sexo : Sexo,
    val email : String,
    val cidade : String,
    val salario : Int,
    val estado : String,
) : Pessoa (
    nome = nome,
    idade = idade,
    cpf = cpf,
    sexo = Sexo.MASCULINO) {
}