package br.com.timedomatheus.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Msg(@SerializedName("produtos") @Expose var listaProdutos: List<Produto>)