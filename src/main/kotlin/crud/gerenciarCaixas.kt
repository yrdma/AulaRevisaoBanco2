package org.example.crud

import org.example.entidades.CaixaDAgua
import org.example.enumeradores.Material
import java.sql.Connection
import java.sql.ResultSet

val conectar = EntidadeJDBC(
    url = "jdbc:postgresql://localhost:5432/postgres",
    usuario = "postgres",
    senha = "postgres"
)

fun criarTabelaCaixa(){



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
fun cadastrarCaixa(id : Int){

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
    val c = CaixaDAgua(
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
    val banco = conectar.conectarComBanco()!!
    if (id == 0){
        val salvar = banco.prepareStatement(
            "INSERT INTO CaixaDAgua" +
                    " (material, cor, peso, preco, altura, largura, profundidade, tampa, capacidade, marca)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
        )
        salvar.setString(1, c.material.name)
        salvar.setString(2, c.cor)
        salvar.setDouble(3, c.peso)
        salvar.setString(4, c.preco.toString())
        salvar.setDouble(5, c.altura)
        salvar.setDouble(6, c.largura)
        salvar.setDouble(7, c.profundidade)
        salvar.setString(8, c.tampa)
        salvar.setInt(9, c.capacidade)
        salvar.setString(10, c.marca)
        salvar.executeUpdate()//isso fara um COMMIT no banco
       salvar.close()

    }else{
        val sql = "UPDATE  CaixaDAgua SET " +
                " material = ?," +
                " cor = ?," +
                " peso = ?," +
                " preco = ?," +
                " altura = ?," +
                " largura = ?," +
                " profundidade = ?," +
                " tampa = ?," +
                " capacidade = ?," +
                " marca = ?" +
                " WHERE id = ?"
        val editar = banco.prepareStatement(sql)
        editar.setInt(11, id)
        editar.setString(1, c.material.name)
        editar.setString(2, c.cor)
        editar.setDouble(3, c.peso)
        editar.setString(4, c.preco.toString())
        editar.setDouble(5, c.altura)
        editar.setDouble(6, c.largura)
        editar.setDouble(7, c.profundidade)
        editar.setString(8, c.tampa)
        editar.setInt(9, c.capacidade)
        editar.setString(10, c.marca)
        editar.executeUpdate()//isso fara um COMMIT no banco
        editar.close()
    }

    banco.close()

}

fun editarCaixa(){
    println("Digite o ID que deseja editar")
    var id = readln().toInt()
    val banco = conectar.conectarComBanco()
    val sqlBusca = "SELECT * FROM CaixaDAgua WHERE id = ?"
    val resultados = banco!!.prepareStatement(sqlBusca)
    resultados.setInt(1,id)
    val retorno = resultados.executeQuery()


    while (retorno.next()){
        println("------------------------------------------------------")
        println("ID:${retorno.getString("id")}")
        id = retorno.getString("id").toInt()
        println("MATERIAL:${retorno.getString("material")}")
        println("COR:${retorno.getString("cor")}")
        println("PESO:${retorno.getString("peso")}")
        println("PRECO:${retorno.getString("preco")}")
        println("ALTURA:${retorno.getString("altura")}")
        println("LARGURA:${retorno.getString("largura")}")
        println("PROFUNDIDADE:${retorno.getString("profundidade")}")
        println("TAMPA:${retorno.getString("tampa")}")
        println("CAPACIDADE:${retorno.getString("capacidade")}")
        println("MARCA:${retorno.getString("marca")}")
    }
    println("Faça suas alterações: ")
    cadastrarCaixa(id)
    banco.close()

}

fun listarCaixas(){
    val banco = conectar.conectarComBanco()
    val sql = "SELECT * FROM CaixaDAgua"
    // aPÓS CONSULTAR O bANCO USANDO UM SQL JUNTO DA FUNÇÃO executeQuery
    //A consulta, se assertiva, retorna um array
    val resultados : ResultSet = banco!!.createStatement().executeQuery(sql)

    while (resultados.next()){
        println("------------------------------------------------------")
        println("MATERIAL:${resultados.getString("material")}")
        println("COR:${resultados.getString("cor")}")
        println("PESO:${resultados.getString("peso")}")
        println("PRECO:${resultados.getString("preco")}")
        println("ALTURA:${resultados.getString("altura")}")
        println("LARGURA:${resultados.getString("largura")}")
        println("PROFUNDIDADE:${resultados.getString("profundidade")}")
        println("TAMPA:${resultados.getString("tampa")}")
        println("CAPACIDADE:${resultados.getString("capacidade")}")
        println("MARCA:${resultados.getString("marca")}")
    }
    banco.close()
}

fun excluirCaixa(){
    println("Digite o ID que deseja excluir")
    val id = readln().toInt()
    val banco = conectar.conectarComBanco()
    val sqlBusca = "SELECT * FROM CaixaDAgua WHERE id = ?"
    val resultados = banco!!.prepareStatement(sqlBusca)
    resultados.setInt(1,id)
    val retorno = resultados.executeQuery()
    while (retorno.next()){
        println("------------------------------------------------------")
        println("ID:${retorno.getString("id")}")
        println("MATERIAL:${retorno.getString("material")}")
        println("COR:${retorno.getString("cor")}")
        println("PESO:${retorno.getString("peso")}")
        println("PRECO:${retorno.getString("preco")}")
        println("ALTURA:${retorno.getString("altura")}")
        println("LARGURA:${retorno.getString("largura")}")
        println("PROFUNDIDADE:${retorno.getString("profundidade")}")
        println("TAMPA:${retorno.getString("tampa")}")
        println("CAPACIDADE:${retorno.getString("capacidade")}")
        println("MARCA:${retorno.getString("marca")}")
    }
    println("Tem certeza que deseja excluir esse registro ?")
    val resposta = readln().lowercase()
    when(resposta){
        "sim"->{
           val deletar =  banco.prepareStatement("DELETE FROM CaixaDAgua WHERE id = ?")
               deletar.setInt(1,id)
               deletar.executeUpdate()
            deletar.close()

        }else->{
            println("Operação cancelada")
        }
    }
    banco.close()
    val sqlDeleta = "DELETE FROM CaixaDAgua WHERE id = ?"

}