package dev.ahmannur.memwars.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import dev.ahmannur.memwars.R
import dev.ahmannur.memwars.data.GameInfoProvider

import androidx.appcompat.widget.Toolbar
import dev.ahmannur.memwars.fragments.GameSelectionFragment
import dev.ahmannur.memwars.fragments.IntroductionFragment

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
                GameInfoProvider.loadGames(this)
        val toolbar: Toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val headerView = navView.getHeaderView(0)
        val nameTextView = headerView.findViewById<TextView>(R.id.nameTextView)
        val avatarImageView = headerView.findViewById<ImageView>(R.id.avatarImageView)

        nameTextView.text = "Niloy" // Replace with your name
        avatarImageView.setImageResource(R.drawable.ic_launcher_foreground)

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        transaction.add(R.id.introduction_fragment_container, IntroductionFragment())
        transaction.add(R.id.game_selection_fragment_container, GameSelectionFragment())
        transaction.commit()
    }
}