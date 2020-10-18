package com.example.MadLevel4Task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madLevel4Task2.R
import kotlinx.android.synthetic.main.item_game.view.*

class GameAdapter(private val games: List<Game>):
    RecyclerView.Adapter<GameAdapter.ViewHolder>()
{
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databind(game: Game) {

            itemView.date.text = game.date
            itemView.result2.text = game.result

            when (game.movePlayer){
                1 -> itemView.youThrow5.setImageResource(R.drawable.rock)
                2 -> itemView.youThrow5.setImageResource(R.drawable.paper)
                3 -> itemView.youThrow5.setImageResource(R.drawable.scissors)
            }

            when (game.movePC){
                1 -> itemView.computerThrowImg5.setImageResource(R.drawable.rock)
                2 -> itemView.computerThrowImg5.setImageResource(R.drawable.paper)
                3 -> itemView.computerThrowImg5.setImageResource(R.drawable.scissors)
            }
        }
    }
    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }
    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return games.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(games[position])
    }
}