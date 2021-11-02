package com.example.twisterpm.models

import androidx.navigation.fragment.findNavController
import com.example.twisterpm.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth

data class Authentication(val user: FirebaseUser,val password:FirebaseUser){

/*    private lateinit var auth: FirebaseAuth
    val currentUser = auth.currentUser

    if (currentUser != null) {
        binding.emailEditText.setText(currentUser.email)
    }
    binding.textviewFirst.text = "Current user ${currentUser?.email}"
    binding.buttonFirst.setOnClickListener {
        val email = binding.emailEditText.text.toString().trim()
        val password = binding.passwordEditText.text.toString().trim()
        if (email.isEmpty()) {
            binding.emailEditText.error = "No email"
            return@setOnClickListener
        }
        if (password.isEmpty()) {
            binding.passwordEditText.error = "No Password"
            return@setOnClickListener
        }
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            } else {
                binding.textviewFirst.text = task.exception?.message
            }
        }
    }
    binding.createUser.setOnClickListener {
        val email = binding.emailEditText.text.toString().trim()
        val password = binding.passwordEditText.text.toString().trim()
        if (email.isEmpty()) {
            binding.emailEditText.error = "No email"
            return@setOnClickListener
        }
        if (password.isEmpty()) {
            binding.passwordEditText.error = "No password"
            return@setOnClickListener
        }
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                binding.textviewFirst.text = "User created. Now please sign in"
            } else {
                binding.textviewFirst.text = task.exception?.message
            }
        }
    }*/
}
