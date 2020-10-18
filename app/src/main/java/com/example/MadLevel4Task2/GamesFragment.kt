package com.example.MadLevel4Task2
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madLevel4Task2.R
import kotlinx.android.synthetic.main.fragment_games.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GamesFragment : Fragment() {

    private lateinit var gameRepository: GameRepository

    private val reminders = arrayListOf<Game>()
    private val reminderAdapter = GameAdapter(reminders)

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        observeAddReminderResult()

//        gameRepository = GameRepository(requireContext())
//        getRemindersFromDatabase()


    }

    private fun initViews() {
        // Initialize the recycler view with a linear layout manager, adapter
//        rvReminders.layoutManager =
//            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
//        rvReminders.adapter = reminderAdapter
//        rvReminders.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
//
//        createItemTouchHelper().attachToRecyclerView(rvReminders)


    }

    private fun observeAddReminderResult() {
//        setFragmentResultListener(REQ_REMINDER_KEY) { key, bundle ->
//            bundle.getString(BUNDLE_REMINDER_KEY)?.let {
//                val reminder = Game(it)
//
//                reminders.add(reminder)
//                reminderAdapter.notifyDataSetChanged()
//                reminderRepository.insertReminder(reminder)
//                getRemindersFromDatabase()
//                CoroutineScope(Dispatchers.Main).launch {
//                    withContext(Dispatchers.IO) {
//                        gameRepository.insertReminder(reminder)
//                    }
//                    getRemindersFromDatabase()
//                }
//
//            } ?: Log.e("ReminderFragment", "Request triggered, but empty reminder text!")
//
//        }
    }


    private fun startGame() {
        lastThrow = currentThrow
        currentThrow = (1..3).random()
        updateUI()
    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */
    private fun updateUI() {
        when (currentThrow) {
            1 -> imageView.setImageResource(R.drawable.rock)
            2 -> imageView.setImageResource(R.drawable.paper)
            3 -> imageView.setImageResource(R.drawable.scissors)


            /**
             * Create a touch helper to recognize when a user swipes an item from a recycler view.
             * An ItemTouchHelper enables touch behavior (like swipe and move) on each ViewHolder,
             * and uses callbacks to signal when a user is performing these actions.
             */
//    private fun createItemTouchHelper(): ItemTouchHelper {
//
//        // Callback which is used to create the ItemTouch helper. Only enables left swipe.
//        // Use ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) to also enable right swipe.
//        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
//
//            // Enables or Disables the ability to move items up and down.
//            override fun onMove(
//                recyclerView: RecyclerView,
//                viewHolder: RecyclerView.ViewHolder,
//                target: RecyclerView.ViewHolder
//            ): Boolean {
//                return false
//            }
//
//            // Callback triggered when a user swiped an item.
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                val position = viewHolder.adapterPosition
//                reminders.removeAt(position)
//                reminderAdapter.notifyDataSetChanged()
//                val reminderToDelete = reminders[position]
//                reminderRepository.deleteReminder(reminderToDelete)
//                getRemindersFromDatabase()
//                CoroutineScope(Dispatchers.Main).launch {
//                    withContext(Dispatchers.IO) {
//                        gameRepository.deleteReminder(reminderToDelete)
//                    }
//                    getRemindersFromDatabase()
//                }
//
//            }
//        }
//        return ItemTouchHelper(callback)
//    }

//    private fun getRemindersFromDatabase() {
//        val reminders = reminderRepository.getAllReminders()
//        this@RemindersFragment.reminders.clear()
//        this@RemindersFragment.reminders.addAll(reminders)
//        reminderAdapter.notifyDataSetChanged()
//        CoroutineScope(Dispatchers.Main).launch {
//            val reminders = withContext(Dispatchers.IO) {
//                gameRepository.getAllReminders()
//            }
//            this@GamesFragment.reminders.clear()
//            this@GamesFragment.reminders.addAll(reminders)
//            reminderAdapter.notifyDataSetChanged()
//        }
//
//    }
        }
    }
}