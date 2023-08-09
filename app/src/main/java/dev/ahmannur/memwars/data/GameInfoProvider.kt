package dev.ahmannur.memwars.data
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.ahmannur.memwars.R
import dev.ahmannur.memwars.adapters.GameAdapter
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream

data class GameInfo(
    val id: Int,
    val name: String,
    val title: String,
    val description: String
    // Add more properties as needed
)
object GameInfoProvider {
    private val games = mutableListOf<GameInfo>()

    fun loadGames(context: Context) {
        val json = context.resources.openRawResource(R.raw.games)
            .bufferedReader().use ({ it.readText() })

        val jsonArray = JSONArray(json)
        for (i in 0 until jsonArray.length()) {
            val jsonObject: JSONObject = jsonArray.getJSONObject(i)
            games.add(
                GameInfo(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    jsonObject.getString("title"),
                    jsonObject.getString("description")
                )
            )
        }
    }
    fun getGameInfo(gameName: String?): GameInfo? {
        return games.firstOrNull { it.name == gameName}
    }
    fun getGameNames(): List<String> {
        return games.map { it.name }
    }
}
