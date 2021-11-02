package com.example.twisterpm

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.twisterpm.databinding.FragmentFirstBinding
import com.example.twisterpm.models.AuthenticationViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val viewModelAuth: AuthenticationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = Firebase.auth
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.fab.hide()
        binding.buttonLogin.setOnClickListener(){
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()
            Log.d(email,"found email")
            Log.d(password,"found password")
            if (email.isEmpty()) {
                binding.emailEditText.error = "No email"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.passwordEditText.error = "No Password"
                return@setOnClickListener
            }
            viewModelAuth.login(email,password)
        }
        viewModelAuth.userLiveData.observe(viewLifecycleOwner, { user ->
            if(user != null){
                Log.d(user.toString(),"found user")
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

            }
            else{
                Log.d(user, "can't find user")
            }
        })

        binding.createUser.setOnClickListener(){
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
            viewModelAuth.createuser(email, password)
        }
}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}