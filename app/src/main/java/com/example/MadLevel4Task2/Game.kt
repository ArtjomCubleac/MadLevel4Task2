package com.example.MadLevel4Task2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "reminderTable")
data class Game(

    @ColumnInfo(name = "game")
    //var date: Date,
    var movePC: Int,
    var movePlayer: Int,
    var result: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

)

