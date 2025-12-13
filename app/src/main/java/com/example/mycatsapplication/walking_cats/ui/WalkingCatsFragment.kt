package com.example.mycatsapplication.walking_cats.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mycatsapplication.databinding.FragmentWalkingCatsBinding
import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WalkingCatsFragment : Fragment(),
    WalkingCatAdapter.AddInDbClick,
    WalkingCatAdapter.DelInDbClick,
    WalkingCatAdapter.ItemClick {

    private val tag = "cats"


    private var _binding: FragmentWalkingCatsBinding? = null
    private val binding get() = _binding!!
    private val walkingCatsViewModel: WalkingCatsViewModel by viewModels()
    private var walkingCatAdapter: WalkingCatAdapter? = null

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
        Log.d(tag, "walkingCatsFragment")

        prepareView()
        observeData()
        walkingCatsViewModel.getAllLocalCats()
    }

    fun observeData() {
        walkingCatsViewModel.walkingCatList.observe(viewLifecycleOwner) {
            if (it != null) {
                it.forEach { item ->
                    Log.d(
                        tag,
                        "cat = ${item.id}, ${item.url}"
                    )
                }
                walkingCatAdapter?.setListOfCats(it as ArrayList)
            }
        }


        walkingCatsViewModel.catIdList.observe(viewLifecycleOwner) {
            if (it != null) {
                walkingCatAdapter?.setListOfCatsIds(it as ArrayList)
            }
        }
    }

    fun prepareView() {

        walkingCatAdapter = WalkingCatAdapter()
        walkingCatAdapter?.setDeleteButtonClickListener(this)
        walkingCatAdapter?.setItemClickListener(this)
        walkingCatAdapter?.setAddButtonClickListener(this)
        binding.catsRecyclerView.adapter = walkingCatAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAddInDbClick(item: CatDataModel?) {
        Log.d(tag, "add in database ${item?.id}")
        if (item != null) {
            walkingCatsViewModel.addCat(item)
        }

    }

    override fun onDeleteFromDbClick(item: CatDataModel?) {
        Log.d(tag, "delete from database ${item?.id}")
        if (item != null) {
            walkingCatsViewModel.deleteCat(item)
        }
    }

    override fun onItemClick(item: CatDataModel?) {
        Log.d(tag, "on item click ${item?.id}")
        if (item != null) {

        }
    }
}