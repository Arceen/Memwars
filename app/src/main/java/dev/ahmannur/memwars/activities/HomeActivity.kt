package dev.ahmannur.memwars.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import dev.ahmannur.memwars.R
import dev.ahmannur.memwars.data.GameInfoProvider

import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import dev.ahmannur.memwars.fragments.GameSelectionFragment
import dev.ahmannur.memwars.fragments.IntroductionFragment
import dev.ahmannur.memwars.utils.UserAuth

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
                GameInfoProvider.loadGames(this)
        val toolbar: Toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_item_2 -> {
                    // Handle the settings menu item click (Logout)
                    UserAuth.logoutUser()
                    // You can also navigate to the login screen or perform other actions after logout if needed
                    drawerLayout.closeDrawer(GravityCompat.START)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                // Add more cases for other menu items if needed
                else -> false
            }
        }
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val headerView = navView.getHeaderView(0)
        val nameTextView = headerView.findViewById<TextView>(R.id.nameTextView)
        val avatarImageView = headerView.findViewById<ImageView>(R.id.avatarImageView)

        nameTextView.text = UserAuth.getUserEmail() // Replace with your name
        avatarImageView.setImageResource(R.drawable.ic_launcher_foreground)

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        transaction.add(R.id.introduction_fragment_container, IntroductionFragment())
        transaction.add(R.id.game_selection_fragment_container, GameSelectionFragment())
        transaction.commit()
    }


}