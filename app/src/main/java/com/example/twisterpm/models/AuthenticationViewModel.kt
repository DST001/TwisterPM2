package com.example.twisterpm.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.twisterpm.repository.AuthenticationRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthenticationViewModel : ViewModel() {
    //private val repository = AuthenticationRepository()
    val userLiveData: MutableLiveData<FirebaseUser> = MutableLiveData<FirebaseUser>()
    private var auth = FirebaseAuth.getInstance()
    val errorLiveData: MutableLiveData<String> = MutableLiveData<String>()
    fun login(email: String, password: String) {
        // repository.currentUser
        Log.d("email password", email + " " + password)
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("apple","successful login")
                userLiveData.value = auth.currentUser
            } else {
                Log.d("apple","can't login" + task.exception?.message)
                errorLiveData.value = task.exception?.message
            }
        }
    }

    fun createuser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d(task.toString(),"new user")
                userLiveData.value = auth.currentUser

            }
        }

    }

    fun logout() {
        Log.d("logout","loged out")
        auth.signOut()
    }
}