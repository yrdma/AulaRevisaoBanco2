package org.example.crud

import java.sql.Connection
import java.sql.DriverManager

class EntidadeJDBC (
    val url : String,
    val usuario : String,
    val senha :String,
){
    fun conectarComBanco() : Connection?{
        try {
            val coneccao : Connection =
                DriverManager.getConnection(
                    this.url, this.usuario, this.senha
                )
            println("Conectou!")
            return coneccao
        } catch (erro : Exception){
            println(erro.printStackTrace())
        }
        return null

    }
}