package com.example.MadLevel4Task2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gamesTable")
data class Game(

    //var date: Date,
    @ColumnInfo(name = "movePC")
    var movePC: Int,
    @ColumnInfo(name = "movePlayer")
    var movePlayer: Int,
    @ColumnInfo(name = "result")
    var result: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

)

