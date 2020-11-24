package br.com.timedomatheus.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.timedomatheus.entities.Produto
import br.com.timedomatheus.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(val repository: Repository) : ViewModel() {
    val produtos = MutableLiveData<List<Produto>>()

    fun getProdutos() {
        try {

            viewModelScope.launch {
                produtos.value = repository.getAllProdutosRepo().listaProdutos
            }

        } catch (e: Exception) {
            Log.e("MainViewModel", e.toString())
        }
    }
}