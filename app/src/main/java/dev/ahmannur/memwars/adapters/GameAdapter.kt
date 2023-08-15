package dev.ahmannur.memwars.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.ahmannur.memwars.viewholders.GameViewHolder
import dev.ahmannur.memwars.R

class GameAdapter(private val gameNames: Array<String>, private val gameDescriptions: Array<String>, private val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<GameViewHolder>() {
    interface OnItemClickListener {
        fun onGameSelected(gameName: String)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.game_card_layout, parent, false)
        return GameViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val gameName = gameNames[position]
        val gameDescription = gameDescriptions[position]
        holder.bind(gameName, gameDescription, itemClickListener)
    }


    override fun getItemCount(): Int {
        return gameNames.size
    }
}