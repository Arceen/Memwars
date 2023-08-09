package dev.ahmannur.memwars.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.ahmannur.memwars.adapters.GameAdapter
import dev.ahmannur.memwars.R
import dev.ahmannur.memwars.activities.GameIntroductionActivity
import dev.ahmannur.memwars.data.GameInfoProvider

class GameSelectionFragment : Fragment(), GameAdapter.OnItemClickListener {
    override fun onGameSelected(gameName: String) {
        val ctx = requireContext()
        val intent = Intent(ctx, GameIntroductionActivity::class.java)
        intent.putExtra("gameName", gameName)
        ctx.startActivity(intent)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val gameNames = GameInfoProvider.getGameNames().toTypedArray()
        val adapter = GameAdapter(gameNames, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    }
}