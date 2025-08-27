package org.example.entidades

import org.example.enumeradores.Sexo

open class Pessoa (
    val nome : String,
    val cpf : Long,
    val sexo : Sexo,
    val idade : Int
){}