package dev.ahmannur.memwars.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import dev.ahmannur.memwars.R
import dev.ahmannur.memwars.utils.SnackbarMessage
import dev.ahmannur.memwars.utils.UserAuth

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerButton = findViewById<Button>(R.id.registerButton);
        val emailEditText = findViewById<EditText>(R.id.emailEditText);
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText);

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Validate email and password if needed
            if (email.isNotEmpty() && password.isNotEmpty()) {
                UserAuth.registerUser(email, password) { success ->
                    if (success) {
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        val root = findViewById<View>(android.R.id.content)
                        SnackbarMessage.showMessage(
                            root,
                            "Registration Failed. Please Try Later",
                            "Error"
                        )
                    }
                }
            }
        }
    }


}