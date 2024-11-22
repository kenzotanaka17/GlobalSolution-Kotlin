package kenzotanaka17.com.github.andrekenzo_rm94306.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kenzotanaka17.com.github.andrekenzo_rm94306.data.DicaDao
import kenzotanaka17.com.github.andrekenzo_rm94306.data.DicaDatabase
import kenzotanaka17.com.github.andrekenzo_rm94306.model.DicaModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DicasViewModel(application: Application) : AndroidViewModel(application) {

    private val dicaDao: DicaDao

    val dicasLiveData: LiveData<List<DicaModel>>

    init {
        val database = Room.databaseBuilder(
            getApplication(),
            DicaDatabase::class.java,
            "dicas_database"
        )
            .fallbackToDestructiveMigration() // Adicionado esta linha
            .build()

        dicaDao = database.dicaDao()
        dicasLiveData = dicaDao.getAll()
    }

    fun addDica(name: String, description: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val newDica = DicaModel(name = name, description = description)
            dicaDao.insert(newDica)
        }
    }

    fun removeDica(dica: DicaModel) {
        viewModelScope.launch(Dispatchers.IO) {
            dicaDao.delete(dica)
        }
    }
}