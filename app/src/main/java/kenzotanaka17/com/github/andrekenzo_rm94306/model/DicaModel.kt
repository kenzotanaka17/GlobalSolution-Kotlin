package kenzotanaka17.com.github.andrekenzo_rm94306.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DicaModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String
)
