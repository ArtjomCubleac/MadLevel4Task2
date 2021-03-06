package com.example.MadLevel4Task2

import androidx.room.*


@Dao
interface GameDao {

    @Query("SELECT * FROM gamesTable")
    suspend fun getAllGames(): List<Game>

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Update
    suspend fun updateGame(game: Game)

    @Query("DELETE FROM gamesTable")
    suspend fun deleteAllGames()

}
