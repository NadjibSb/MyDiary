package com.esi.mydiary.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.esi.mydiary.db.Diary
import com.esi.mydiary.R

const val KEY="ID"

class ItemAdapter(val list: List<Diary>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.creat(parent)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val diary = list[position]
        holder.bind(diary)
    }


    class ViewHolder private constructor(parent: View) : RecyclerView.ViewHolder(parent) {
        var title: TextView
        var date: TextView
        var icon: ImageView
        var container: ConstraintLayout

        init {
            title = parent.findViewById(R.id.title)
            date = parent.findViewById(R.id.date)
            icon = parent.findViewById(R.id.icon_img)
            container = parent.findViewById(R.id.container)
        }

        companion object {
            fun creat(parent: ViewGroup): ViewHolder {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item, parent, false)
                return ViewHolder(itemView)
            }
        }

        fun bind(diary: Diary) {
            title.text = diary.title
            date.text = diary.date.toString()
            icon.setImageResource(R.drawable.ic_image)
            container.setOnClickListener { v ->
                val action = HomeFragmentDirections.actionHomeFragmentToDiaryDetailsFragment(diary.pk)
                Navigation.findNavController(v).navigate(action)
            }
        }
    }
/*
    fun navigate(mItemSelected: Diary) {
        val mFragment = HomeFragment.newInstance()
        val mBundle = Bundle()
        mBundle.putInt(KEY, mItemSelected.pk)
        mFragment.arguments = mBundle
        switchContent(R.id.host_fragment, mFragment)
    }

    private fun switchContent(id: Int, fragment: Fragment) {
        if (mContext == null)
            return
        if ( is MainActivity) {
            val mainActivity = mContext as MainActivity
            mainActivity.switchContent(id, fragment)
        }

    }*/

}