package com.example.mycatsapplication.local_cats.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.mycatsapplication.MainViewModel
import com.example.mycatsapplication.databinding.FragmentLocalCatsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LocalCatsFragment : Fragment() {

    companion object {
        fun newInstance() = LocalCatsFragment()
    }

    private val tag = "cats"
    private var _binding: FragmentLocalCatsBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    private val localCatsViewModel: LocalCatsViewModel by viewModels()

    private val sharedViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocalCatsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeValues()
    }

    private fun observeValues() {
        localCatsViewModel.catsIds.observe(viewLifecycleOwner) {
            it.forEach { item -> Log.d(tag, "id=$item ") }

        }
        localCatsViewModel.localCats.observe(viewLifecycleOwner) {
            it.forEach { item -> Log.d(tag, "localCat=${item} ") }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}