package com.example.mycatsapplication.walking_cats.ui


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mycatsapplication.R
import com.example.mycatsapplication.databinding.ItemCatViewBinding
import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel

class WalkingCatAdapter() : RecyclerView.Adapter<WalkingCatAdapter.ViewHolder>() {


    private var catsList = ArrayList<CatDataModel>()
    private var itemClickListener: ItemClick? = null
    private var addButtonListener: AddInDbClick? = null
    private var delButtonListener: DelInDbClick? = null
    private var _catsIdList = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCatViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), itemClickListener, addButtonListener, delButtonListener
        )
    }

    override fun onBindViewHolder(holder: WalkingCatAdapter.ViewHolder, position: Int) {
        holder.bind(catsList[position])
    }

    override fun getItemCount(): Int {
        return catsList.size
    }

    fun setListOfCatsIds(list: ArrayList<String>) {
        this._catsIdList = list
        Log.d("cats", "adapter catIdList size = " + this._catsIdList?.size)
        notifyDataSetChanged()

    }

    fun setListOfCats(list: ArrayList<CatDataModel>) {
        this.catsList = list
        notifyDataSetChanged()
    }

    fun getItemViewPosition(position: Int): CatDataModel {
        return catsList[position]
    }

    fun setItemClickListener(itemClickListener: ItemClick) {
        this.itemClickListener = itemClickListener
    }

    fun setAddButtonClickListener(addButtonListener: AddInDbClick) {
        this.addButtonListener = addButtonListener
    }

    fun setDeleteButtonClickListener(delButtonListener: DelInDbClick) {
        this.delButtonListener = delButtonListener
    }

    interface ItemClick {
        fun onItemClick(item: CatDataModel?)
    }

    interface AddInDbClick {
        fun onAddInDbClick(item: CatDataModel?)
    }

    interface DelInDbClick {
        fun onDeleteFromDbClick(item: CatDataModel?)
    }

    inner class ViewHolder(
        private val binding: ItemCatViewBinding, private val itemClick: ItemClick?,
        private val addInDbClick: AddInDbClick?, private val delInDbClick: DelInDbClick?
    ) :
        RecyclerView.ViewHolder(binding.root) {
        private val date: TextView = binding.textViewDate
        private val title: TextView = binding.textViewTitle
        private val imageView: ImageView = binding.imageViewPicture
        private val addButton: ImageButton = binding.addInDbButton
        private val delButton: ImageButton = binding.deleteInDbButton
        private var responseModel: CatDataModel? = null

        init {
            itemView.setOnClickListener {
                itemClick?.onItemClick(responseModel)
            }
            addButton.setOnClickListener {
                addInDbClick?.onAddInDbClick(responseModel)
            }
            delButton.setOnClickListener {
                delInDbClick?.onDeleteFromDbClick(responseModel)
            }
        }

        fun bind(responseModel: CatDataModel) {
            this.responseModel = responseModel
            date.text = responseModel.id
            title.text = responseModel.url
            if (_catsIdList?.contains(responseModel.id) == true) {
                addButton.visibility = View.INVISIBLE
                delButton.visibility = View.VISIBLE
            } else {
                addButton.visibility = View.VISIBLE
                delButton.visibility = View.INVISIBLE
            }



            Glide
                .with(itemView.context)
                .load(responseModel.url)
                .placeholder(R.drawable.ic_android_black_24dp)
                .into(imageView)

        }
    }
}