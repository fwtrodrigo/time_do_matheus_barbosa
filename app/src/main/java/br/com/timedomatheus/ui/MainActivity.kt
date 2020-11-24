package br.com.timedomatheus.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.timedomatheus.R
import br.com.timedomatheus.entities.ProdutoAdapter
import br.com.timedomatheus.repository.repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getProdutos()
        viewModel.produtos.observe(this) {
            rcMain.adapter = ProdutoAdapter(it)
            rcMain.layoutManager = LinearLayoutManager(this)
            rcMain.setHasFixedSize(true)

        }
    }

    private val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }
    }


}