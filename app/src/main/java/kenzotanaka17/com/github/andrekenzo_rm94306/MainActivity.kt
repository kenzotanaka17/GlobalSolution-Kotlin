package kenzotanaka17.com.github.andrekenzo_rm94306

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

import kenzotanaka17.com.github.andrekenzo_rm94306.viewmodel.DicasAdapter
import kenzotanaka17.com.github.andrekenzo_rm94306.viewmodel.DicasViewModel
import kenzotanaka17.com.github.andrekenzo_rm94306.viewmodel.DicasViewModelFactory
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: DicasViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Lista de dicas"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val dicasAdapter = DicasAdapter { dica ->
            viewModel.removeDica(dica)
        }
        recyclerView.adapter = dicasAdapter

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)
        val descriptionEditText = findViewById<EditText>(R.id.editTextDescription)

        button.setOnClickListener {
            if (editText.text.isEmpty()) {
                editText.error = "Preencha o nome da dica"
                return@setOnClickListener
            }

            if (descriptionEditText.text.isEmpty()) {
                descriptionEditText.error = "Preencha a descrição da dica"
                return@setOnClickListener
            }

            viewModel.addDica(editText.text.toString(), descriptionEditText.text.toString())
            editText.text.clear()
            descriptionEditText.text.clear()
        }


        val viewModelFactory = DicasViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DicasViewModel::class.java)

        viewModel.dicasLiveData.observe(this) { dicas ->
            dicasAdapter.updateDicas(dicas)
        }
    }
}