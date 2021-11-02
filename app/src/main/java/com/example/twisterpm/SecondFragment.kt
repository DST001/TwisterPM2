package com.example.twisterpm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.twisterpm.model.MyAdapter
import com.example.twisterpm.databinding.FragmentSecondBinding
import com.example.twisterpm.models.MessagesViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val messagesViewModel: MessagesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textviewSecond.text = Firebase.auth.currentUser?.email

        messagesViewModel.messageLiveData.observe(viewLifecycleOwner, { messages ->
            binding.recyclerView.layoutManager = LinearLayoutManager(activity)
            Log.d("APPLE", "observer")
            val adaptor = MyAdapter(messages) { position ->
                val selmessage = messages[position]
                val action = SecondFragmentDirections.actionSecondFragmentToCommentFragment2(selmessage)
                findNavController().navigate(action)
                Log.d("APPLE","position" + position)

            }
            Log.d("APPLE", "adaptormade")
            binding.recyclerView.adapter = adaptor
            Log.d("APPLE", "recyclerView")
        })
        messagesViewModel.getPostsM()

        Log.d("APPLE", "getdata")
        /*binding..setOnClickListener {
            Firebase.auth.signOut()
            findNavController().popBackStack()
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
