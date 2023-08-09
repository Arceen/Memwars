package dev.ahmannur.memwars.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dev.ahmannur.memwars.GameInfoDataSource
import dev.ahmannur.memwars.R
import dev.ahmannur.memwars.data.GameInfoProvider

class GameIntroductionActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameName = intent.getStringExtra("gameName");
        Log.e("GameName", "COMNES HERE" );
        setContentView(R.layout.activity_game_introduction);

        val titleTextView = findViewById<TextView>(R.id.gameTitleTextView)
        val descriptionTextView = findViewById<TextView>(R.id.gameDescriptionTextView)
        val startButton = findViewById<Button>(R.id.gameStartButton)
        val gameInfo = GameInfoProvider.getGameInfo(gameName)

        if (gameInfo != null) {
            titleTextView.text = gameInfo.title
            descriptionTextView.text = gameInfo.description
        } else {
            titleTextView.text = "Unknown Game"
            descriptionTextView.text = "No description available for this game"
        }


        startButton.setOnClickListener {
            Log.i("Button Clicked", "Here's to the game")
        }
    }
}