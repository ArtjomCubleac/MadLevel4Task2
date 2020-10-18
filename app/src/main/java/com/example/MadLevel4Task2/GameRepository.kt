package com.example.MadLevel4Task2

import android.content.Context

public class GameRepository(context: Context) {

    private var gameDao: GameDao

    init {
        val reminderRoomDatabase = GameRoomDatabase.getDatabase(context)
        gameDao = reminderRoomDatabase!!.reminderDao()
    }

    suspend fun getAllReminders(): List<Game> {
        return gameDao.getAllReminders()
    }

    suspend fun insertReminder(game: Game) {
        gameDao.insertReminder(game)
    }

    suspend fun deleteReminder(game: Game) {
        gameDao.deleteReminder(game)
    }


    suspend fun updateReminder(game: Game) {
        gameDao.updateReminder(game)
    }
}