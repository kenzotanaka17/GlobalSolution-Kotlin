package kenzotanaka17.com.github.andrekenzo_rm94306.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kenzotanaka17.com.github.andrekenzo_rm94306.model.DicaModel

@Dao
interface DicaDao {

    @Query("SELECT * FROM DicaModel")
    fun getAll(): LiveData<List<DicaModel>>

    @Insert
    fun insert(dica: DicaModel)
    @Delete
    fun delete(dica: DicaModel)
}