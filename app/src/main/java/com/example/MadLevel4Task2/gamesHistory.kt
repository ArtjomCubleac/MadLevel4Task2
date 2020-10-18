package com.example.MadLevel4Task2

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madLevel4Task2.R
import kotlinx.android.synthetic.main.fragment_games.*
import kotlinx.android.synthetic.main.game_history.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddReminderFragment : Fragment() {

    private val games = arrayListOf<Game>()
    private val gameAdapter = GameAdapter(games)
    private lateinit var gameRepository: GameRepository

    private val mainScope = CoroutineScope(Dispatchers.Main)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.game_history, container, false)
        initViews()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true);
        gameRepository = GameRepository(requireContext())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // First clear current all the menu items
        menu.clear()
        // Add the new menu items
        inflater.inflate(R.menu.menu_history, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    private fun initViews() {
      //   Initialize the recycler view with a linear layout manager, adapter
        gamesHistoryRV.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        gamesHistoryRV.adapter = gameAdapter
        gamesHistoryRV.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))


        getGamesFromDatabase()

        //createItemTouchHelper().attachToRecyclerView(rvReminders)
    }

    private fun getGamesFromDatabase() {
        mainScope.launch {
            val games = withContext(Dispatchers.IO) {
                gameRepository.getAllGames()
            }
            this@AddReminderFragment.games.clear()
            this@AddReminderFragment.games.addAll(games)
            this@AddReminderFragment.gameAdapter.notifyDataSetChanged()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_delete -> {
                removeAllProducts()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun removeAllProducts() {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.deleteAllGames()
            }
            getGamesFromDatabase()
        }


    }
}