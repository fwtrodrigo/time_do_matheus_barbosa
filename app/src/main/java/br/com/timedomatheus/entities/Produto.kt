package br.com.timedomatheus.entities

data class Produto(
    val id: Int,
    var nome_prod: String,
    var url: String,
    var id_emp: Int,
    var nome_emp: String,
    var valor: String,
    var dt_exp: String,
    var logo_emp: String,
    var vol_prod: String
)