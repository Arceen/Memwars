package dev.ahmannur.memwars.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ahmannur.memwars.R
import dev.ahmannur.memwars.adapters.GameAdapter

class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val gameNameTextView: TextView = itemView.findViewById(R.id.gameNameTextView)
    private val gameDescriptionTextView: TextView = itemView.findViewById(R.id.gameDescriptionTextView)
    fun bind(gameName: String, gameDescription: String, clickListener: GameAdapter.OnItemClickListener) {


        gameNameTextView.text = gameName
        gameDescriptionTextView.text = gameDescription
        itemView.setOnClickListener {
            clickListener.onGameSelected(gameName)
        }
    }
}