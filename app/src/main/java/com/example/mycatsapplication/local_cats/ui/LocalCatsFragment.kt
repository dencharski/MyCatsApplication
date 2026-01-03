package com.example.mycatsapplication.local_cats.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mycatsapplication.R
import com.example.mycatsapplication.databinding.FragmentLocalCatsBinding
import com.example.mycatsapplication.utils.Utils
import com.example.mycatsapplication.utils.models.CatDataModel
import com.example.mycatsapplication.walking_cats.ui.WalkingCatAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LocalCatsFragment : Fragment(),
    WalkingCatAdapter.ItemClick,
    WalkingCatAdapter.AddInDbClick,
    WalkingCatAdapter.DelInDbClick {


    private val tag = "cats"
    private var _binding: FragmentLocalCatsBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    private val localCatsViewModel: LocalCatsViewModel by viewModels()
    private var localCatAdapter: WalkingCatAdapter? = null

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

        prepareView()
        observeData()
        localCatsViewModel.getAllLocalCats()
        setLoading()
    }

    private fun observeData() {
        localCatsViewModel.listOfLocalCatsIds.observe(viewLifecycleOwner) {
            it.forEach { item -> Log.d(tag, "local fr id=$item ") }
            localCatAdapter?.setListOfCatsIds(it as ArrayList)
        }
        localCatsViewModel.listOfLocalCats.observe(viewLifecycleOwner) {
            it.forEach { item -> Log.d(tag, "local fr localCat=${item} ") }
            localCatAdapter?.setListOfCats(it as ArrayList)
            setGetData()
        }
    }

    private fun setLoading() {
        binding.catsRecyclerView.visibility = View.INVISIBLE
        binding.progressCircular.visibility = View.VISIBLE
    }

    private fun setGetData() {
        binding.catsRecyclerView.visibility = View.VISIBLE
        binding.progressCircular.visibility = View.INVISIBLE
    }

    private fun prepareView() {

        localCatAdapter = WalkingCatAdapter()
        localCatAdapter?.setDeleteButtonClickListener(this)
        localCatAdapter?.setItemClickListener(this)
        localCatAdapter?.setAddButtonClickListener(this)
        binding.catsRecyclerView.adapter = localCatAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(item: CatDataModel?) {
        Log.d(tag, "loc on item click ${item?.id}")
        if (item != null) {
            val bundle = Bundle()
            bundle.putParcelable(Utils.getCatAppKey(), item)
            findNavController().navigate(
                R.id.action_localCatsFragment_to_currentCatFragment,
                bundle
            )

        }
    }

    override fun onAddInDbClick(item: CatDataModel?) {
        Log.d(tag, "loc add in database ${item?.id}")
        if (item != null) {
            localCatsViewModel.addCat(item)
        }
    }

    override fun onDeleteFromDbClick(item: CatDataModel?) {
        Log.d(tag, "loc delete from database ${item?.id}")
        if (item != null) {
            localCatsViewModel.deleteCat(item)
        }
    }
}