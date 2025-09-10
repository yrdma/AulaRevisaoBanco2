package org.example.ui

import org.example.crud.cadastrarCaixa
import org.example.crud.editarCaixa
import org.example.crud.excluirCaixa
import org.example.crud.listarCaixas

fun menu(){


    do {
        println("1 - Cadastrar Caixa D' Água ")
        println("2 - Editar Caixa D' Água ")
        println("3 - Listar Caixas D' Água ")
        println("4 - Excluir Caixa D' Água ")


        val opcao = readln().toInt()

        when (opcao) {
            0 -> println("Sair")
            1 -> cadastrarCaixa(0)

            2 -> editarCaixa()

            3 -> listarCaixas()

            4 -> excluirCaixa()
            else-> println("Numero Invalido")

        }
    }while(opcao !=0)
}