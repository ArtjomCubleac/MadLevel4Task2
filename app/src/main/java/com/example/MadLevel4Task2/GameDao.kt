package com.example.MadLevel4Task2

import androidx.room.*


@Dao
interface GameDao {

    @Query("SELECT * FROM reminderTable")
    suspend fun getAllReminders(): List<Game>

    @Insert
    suspend fun insertReminder(game: Game)

    @Delete
    suspend fun deleteReminder(game: Game)

    @Update
    suspend fun updateReminder(game: Game)

}
