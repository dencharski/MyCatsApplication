package com.example.mycatsapplication.walking_cats.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.mycatsapplication.MainViewModel
import com.example.mycatsapplication.databinding.FragmentWalkingCatsBinding
import dagger.hilt.android.AndroidEntryPoint




class WalkingCatsFragment : Fragment() {

    private val tag="cats"
    companion object {
        fun newInstance() = WalkingCatsFragment()
    }


    private var _binding: FragmentWalkingCatsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WalkingCatsViewModel by viewModels()
    private val sharedViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWalkingCatsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(tag,"walkingCatsFragment")


    }


}