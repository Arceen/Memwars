package dev.ahmannur.memwars.navigators

import android.content.Context
import android.content.Intent
import dev.ahmannur.memwars.activities.gameactivities.WordWarActivity

object GameSelectionNavigator {

    fun navigateToGame(gameID: Int, context: Context) {
        when (gameID) {
            1 -> {
                val intent = Intent(context, WordWarActivity::class.java)
                context.startActivity(intent)
            }
            else -> {}
        }


    }
}
