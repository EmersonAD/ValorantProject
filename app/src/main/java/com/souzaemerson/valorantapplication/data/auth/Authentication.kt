package com.souzaemerson.valorantapplication.data.auth

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject


class Authentication @Inject constructor(private val mAuth: FirebaseAuth) {

    fun signUp(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.i(TAG, "signUp: Success")
                } else {
                    Log.i(TAG, "signUp: Failure: ${it.exception}")
                }
            }
    }

    fun signIn(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.i(TAG, "signIn: Success")
                } else {
                    Log.i(TAG, "signIn: Failure ${it.exception}")
                }
            }
    }

    companion object {
        const val TAG = "AUTHENTICATION"
    }

}