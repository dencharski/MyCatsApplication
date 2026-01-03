package com.example.mycatsapplication.current_cat.ui

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.mycatsapplication.R
import com.example.mycatsapplication.databinding.FragmentCurrentCatBinding
import com.example.mycatsapplication.utils.Utils
import com.example.mycatsapplication.utils.models.CatDataModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrentCatFragment : Fragment() {

    private val currentCatViewModel: CurrentCatViewModel by viewModels()
    private var _binding: FragmentCurrentCatBinding? = null
    private val binding get() = _binding!!

    private var catDataModel: CatDataModel? = null
    private val tag = "cats"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrentCatBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareView()
        observeData()
        catDataModel =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                arguments?.getParcelable(Utils.getCatAppKey(), CatDataModel::class.java)
            } else {
                arguments?.getParcelable(Utils.getCatAppKey())
            }
        setLoading()
        currentCatViewModel.getCurrentCat(catDataModel?.id.toString())
        currentCatViewModel.getAllLocalCats()
    }

    private fun observeData() {
        currentCatViewModel.currentCatDataModel.observe(viewLifecycleOwner) {
            binding.textViewTitle.text = it.url
            binding.textViewDate.text = it.id
            Glide
                .with(this)
                .load(it.url)
                .placeholder(R.drawable.ic_android_black_24dp)
                .into(binding.imageViewPicture)

            setGetData()
        }

        currentCatViewModel.catIdList.observe(viewLifecycleOwner) {
            if (it.contains(catDataModel?.id)) {
                binding.addInDbButton.visibility = View.INVISIBLE
                binding.deleteInDbButton.visibility = View.VISIBLE
            } else {
                binding.addInDbButton.visibility = View.VISIBLE
                binding.deleteInDbButton.visibility = View.INVISIBLE
            }
        }
    }

    private fun prepareView() {
        binding.addInDbButton.setOnClickListener { onAddInDbClick(catDataModel) }
        binding.deleteInDbButton.setOnClickListener { onDeleteFromDbClick(catDataModel) }
    }

    private fun setLoading() {
        binding.dataLinearLayout.visibility = View.INVISIBLE
        binding.progressCircular.visibility = View.VISIBLE
    }

    private fun setGetData() {
        binding.dataLinearLayout.visibility = View.VISIBLE
        binding.progressCircular.visibility = View.INVISIBLE
    }

    fun onAddInDbClick(item: CatDataModel?) {
        Log.d(tag, "add in database ${item?.id}")
        if (item != null) {
            currentCatViewModel.addCat(item)
        }
    }

    fun onDeleteFromDbClick(item: CatDataModel?) {
        Log.d(tag, "delete from database ${item?.id}")
        if (item != null) {
            currentCatViewModel.deleteCat(item)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}