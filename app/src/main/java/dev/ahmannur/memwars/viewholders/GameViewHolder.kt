package dev.ahmannur.memwars.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ahmannur.memwars.R
import dev.ahmannur.memwars.adapters.GameAdapter

class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val gameNameTextView: TextView = itemView.findViewById(R.id.gameNameTextView)

    fun bind(gameName: String, clickListener: GameAdapter.OnItemClickListener) {
        val gameNameTextView: TextView = itemView.findViewById(R.id.gameNameTextView)
        gameNameTextView.text = gameName

        itemView.setOnClickListener {
            clickListener.onGameSelected(gameName)
        }
    }
}