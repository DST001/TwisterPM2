package com.example.twisterpm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.twisterpm.databinding.FragmentCommentBinding
import com.example.twisterpm.models.AuthenticationViewModel
import com.example.twisterpm.models.MessagesViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CommentFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentCommentBinding? = null
    private val binding get() = _binding!!
    private val messagesViewModel: MessagesViewModel by activityViewModels()
    private val authenticationViewModel: AuthenticationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = Firebase.auth
        _binding = FragmentCommentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.messageselectedid.text = messagesViewModel.selectedMessage()

}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}