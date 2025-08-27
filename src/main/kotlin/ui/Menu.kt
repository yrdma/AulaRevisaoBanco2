package org.example.ui

fun menu(){


    do {
        println("1 - Cadastrar Caixa D' Água ")
        println("2 - Editar Caixa D' Água ")
        println("3 - Listar Caixas D' Água ")
        println("4 - Excluir Caixa D' Água ")


        val opcao = readln().toInt()

        when (opcao) {
            0 -> println("Sair")
            1 -> println("Cadastrando Caixa...")
            2 -> println("Editando Caixa...")
            3 -> println("listando Caixas...")
            4 -> println("Excluindo Caixa...")
            else-> println("Numero Invalido")

        }
    }while(opcao !=0)
}