package org.example.crud

import org.example.entidades.CaixaDAgua
import org.example.enumeradores.Material
import java.sql.Connection


fun criarTabelaCaixa(){
    val conectar = EntidadeJDBC(
        url = "jdbc:postgresql://localhost:5432/postgres",
        usuario = "postgres",
        senha = "postgres"
    )


    val sql = "CREATE TABLE IF NOT EXISTS CaixaDAgua " +
            " (id serial NOT NULL PRIMARY KEY," +
            " material varchar(255)," +
            " cor varchar(255)," +
            " peso float," +
            " preco varchar(255)," +
            " altura float," +
            " largura float," +
            " profundidade float," +
            " tampa varchar(255)," +
            " capacidade int," +
            " marca varchar(255)" +
            ")"
    val banco = conectar.conectarComBanco()
    val enviarParaBanco = banco!!.createStatement().execute(sql)

    println(enviarParaBanco)

}
fun cadastrarCaixa(){
    /*
    val material : Material,
    val cor : String,
    val peso : Double,
    val preco : BigDecimal,
    val altura : Double,
    val largura : Double,
    val profundidade : Double,
    val tampa : String,
    val capacidade : Int,
    val marca : String,
    *
     */
    println("Escolha o materias da Caixa D' Água" )
    println("1 - Polietileno")
    println("2 - Plastico")
    println("3 - Metal")
    println("4 - Aço")
    val opcao = readln().toInt()
    var material : Material
    when(opcao){
        1 -> material = Material.POLIETILENO
        2 -> material = Material.PLASTICO
        3 -> material = Material.METAL
        4 -> material = Material.ACO
        else -> material = Material.PLASTICO

    }
    println("Digite a cor da Caixa D' Água")
    val cor = readln()

    println("Digite o Peso da Caixa D' Água")
    val peso = readln().toDouble()

    println("Digite o preço da Caixa D' Água")
    val preco = readln().toBigDecimal()

    println("Digite o altura da Caixa D' Água")
    val altura = readln().toDouble()

    println("Digite o Largura da Caixa D' Água")
    val largura = readln().toDouble()

    println("Digite o Profundidade da Caixa D' Água")
    val profundidade = readln().toDouble()

    println("Digite o Tampa da Caixa D' Água")
    val tampa = readln()

    println("Digite o Capacidade da Caixa D' Água")
    val capacidade = readln().toInt()

    println("Digite o marca da Caixa D' Água")
    val marca = readln()

    //Salvar as Variaveis dentro da classe
    CaixaDAgua(
        material = material,
        cor = cor,
        peso = peso,
        preco = preco,
        altura = altura,
        largura = largura,
        profundidade = profundidade,
        tampa = tampa,
        capacidade = capacidade,
        marca = marca
    )
}

fun editarCaixa(){

}

fun listarCaixas(){

}

fun excluirCaixa(){

}