package dev.ahmannur.memwars.activities
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import dev.ahmannur.memwars.R
import dev.ahmannur.memwars.utils.UserAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logoTextView = findViewById<TextView>(R.id.logoTextView)
        val fadeInSlideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_slide_up)
        logoTextView.startAnimation(fadeInSlideUpAnimation)
        logoTextView.visibility = View.VISIBLE
        val loginButton = findViewById<Button>(R.id.LoginButton1)
        val registerButton = findViewById<Button>(R.id.RegisterButton1)
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }



        if (UserAuth.isUserLoggedIn() == null) {
            // User Not Signed In, Goto SignUpPage
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


}
