package com.example.MadLevel4Task2

import android.content.Context

public class GameRepository(context: Context) {

    private var gameDao: GameDao

    init {
        val reminderRoomDatabase = GameRoomDatabase.getDatabase(context)
        gameDao = reminderRoomDatabase!!.reminderDao()
    }

    suspend fun getAllGames(): List<Game> {
        return gameDao.getAllGames()
    }

    suspend fun insertGame(game: Game) {
        gameDao.insertGame(game)
    }

    suspend fun deleteGame(game: Game) {
        gameDao.deleteGame(game)
    }


    suspend fun updateGame(game: Game) {
        gameDao.updateGame(game)
    }

    suspend fun deleteAllGames() {
        gameDao.deleteAllGames()
    }
}