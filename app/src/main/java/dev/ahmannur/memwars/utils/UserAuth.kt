package dev.ahmannur.memwars.utils
import android.util.Log
import com.google.firebase.auth.FirebaseAuth

object UserAuth {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun isUserLoggedIn(): Boolean {
        print("comes here")
        print(auth.currentUser)
        Log.i("VBA", auth.currentUser.toString())
        return auth.currentUser != null
    }

    fun loginUser(email: String, password: String, onComplete: (Boolean) -> Unit) {
        if(auth.currentUser!=null) return;

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onComplete(true)
                } else {
                    onComplete(false)
                }
            }
    }

    fun registerUser(email: String, password: String, onComplete: (Boolean) -> Unit) {
        if(auth.currentUser!=null) return;

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onComplete(true)
                } else {
                    onComplete(false)
                }
            }
    }
    fun getUserEmail(): String? {
        if(auth.currentUser==null) return null;
        return auth.currentUser!!.email
    }
    fun logoutUser() {
        print("comes here")
        print(auth.currentUser)
        Log.i("VBA", auth.currentUser.toString())
        if(auth.currentUser==null) return;
        auth.signOut()
    }
}