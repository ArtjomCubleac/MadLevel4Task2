package com.example.MadLevel4Task2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.madLevel4Task2.R
import kotlinx.android.synthetic.main.fragment_games.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GamesFragment : Fragment() {

    private lateinit var gameRepository: GameRepository
    private val mainScope = CoroutineScope(Dispatchers.Main)
    private var computerThrow: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_games, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rock.setOnClickListener {
            startGame(1)
        }
        paper.setOnClickListener {
            startGame(2)
        }
        scissors.setOnClickListener {
            startGame(3)
        }

        gameRepository = GameRepository(requireContext())
        getGamesFromDatabase()
    }

    private fun getGamesFromDatabase() {
        mainScope.launch {
            val games = withContext(Dispatchers.IO) {
                gameRepository.getAllGames()
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun startGame(i: Int) {

        val datePlayed = SimpleDateFormat("yyyy.MM.dd HH:mm:ss z")

        when (i) {
            1 -> youThrow.setImageResource(R.drawable.rock)
            2 -> youThrow.setImageResource(R.drawable.paper)
            3 -> youThrow.setImageResource(R.drawable.scissors)
        }
        computerThrow = (1..3).random()

        when (computerThrow) {
            1 -> computerThrowImg.setImageResource(R.drawable.rock)
            2 -> computerThrowImg.setImageResource(R.drawable.paper)
            3 -> computerThrowImg.setImageResource(R.drawable.scissors)
        }

        if (i == 1 && computerThrow == 3) {
            win_lose.setText(R.string.you_win)
        } else if (i == computerThrow) {
            win_lose.setText(R.string.draw)
        } else if (i == 1 && computerThrow == 2){
            win_lose.setText(R.string.you_lose)
        }

        if (i == 2 && computerThrow == 1) {
            win_lose.setText(R.string.you_win)
        } else if (i == computerThrow) {
            win_lose.setText(R.string.draw)
        } else if (i == 2 && computerThrow == 3) {
            win_lose.setText(R.string.you_lose)
        }

        if (i == 3 && computerThrow == 2) {
            win_lose.setText(R.string.you_win)
        } else if (i == computerThrow) {
            win_lose.setText(R.string.draw)
        } else if (i == 3 && computerThrow == 1) {
            win_lose.setText(R.string.you_lose)
        }

        mainScope.launch {
            val game = Game(
                date = datePlayed.format(Date()),
                movePC = computerThrow,
                movePlayer = i,
                result = win_lose.text.toString()
            )

            withContext(Dispatchers.IO) {
                gameRepository.insertGame(game)
                getGamesFromDatabase()
            }
        }

    }


}

