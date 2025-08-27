package org.example.entidades


import org.example.enumeradores.Material
import java.math.BigDecimal

class CaixaDAgua (
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
    //val dimensao : Array<Double>, // Altura, Largura, Profundidade.
) //Aqui vai todos os atributos da classe.
// Sempre que trabalharmos com kotlin precisamos instanciar uma classe em kotlin dentro dos contrutores
// <> - Operador Diamente
//
{

}