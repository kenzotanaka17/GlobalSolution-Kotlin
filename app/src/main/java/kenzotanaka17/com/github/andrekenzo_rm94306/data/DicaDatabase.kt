package kenzotanaka17.com.github.andrekenzo_rm94306.data

import androidx.room.Database
import androidx.room.RoomDatabase
import kenzotanaka17.com.github.andrekenzo_rm94306.model.DicaModel

@Database(entities = [DicaModel::class], version = 2)
abstract class DicaDatabase : RoomDatabase() {

    abstract fun dicaDao(): DicaDao
}