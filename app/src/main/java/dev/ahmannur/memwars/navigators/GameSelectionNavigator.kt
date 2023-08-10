package dev.ahmannur.memwars.navigators

import android.content.Context
import android.content.Intent
import dev.ahmannur.memwars.activities.gameactivities.*

object GameSelectionNavigator {

    fun navigateToGame(gameID: Int, context: Context) {
        when (gameID) {
            1 -> {
                val intent = Intent(context, WordWarActivity::class.java)
                context.startActivity(intent)
            }
            2 -> {
                val intent = Intent(context, WordWarExtremeActivity::class.java)
                context.startActivity(intent)
            }
            3 -> {
                val intent = Intent(context, NumberWarActivity::class.java)
                context.startActivity(intent)
            }
            4 -> {
                val intent = Intent(context, NumberWarExtremeActivity::class.java)
                context.startActivity(intent)
            }
            5 -> {
                val intent = Intent(context, NameWarActivity::class.java)
                context.startActivity(intent)
            }
            6 -> {
                val intent = Intent(context, NameWarExtremeActivity::class.java)
                context.startActivity(intent)
            }
            7 -> {
                val intent = Intent(context, LocationWarActivity::class.java)
                context.startActivity(intent)
            }
            8 -> {
                val intent = Intent(context, LocationWarExtremeActivity::class.java)
                context.startActivity(intent)
            }
        }


    }
}
