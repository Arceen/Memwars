package dev.ahmannur.memwars.utils
import com.google.firebase.auth.FirebaseAuth

object UserAuth {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun isUserLoggedIn(): Boolean {
        return auth.currentUser != null
    }
}