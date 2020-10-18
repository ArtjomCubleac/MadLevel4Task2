package com.example.MadLevel4Task2

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.madLevel4Task2.R



const val REQ_REMINDER_KEY = "req_reminder"
const val BUNDLE_REMINDER_KEY = "bundle_reminder"

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddReminderFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.game_add_reminder, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true);
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // First clear current all the menu items
        menu.clear()
        // Add the new menu items
        inflater.inflate(R.menu.menu_history, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_history -> {
                 findNavController().navigate(R.id.action_addReminderFragment_to_remindersFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}