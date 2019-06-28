package com.esi.mydiary.fragments.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.esi.mydiary.R
import com.esi.mydiary.convertLongToDateString
import com.esi.mydiary.db.Diary


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
        var title: TextView = parent.findViewById(R.id.title)
        var date: TextView = parent.findViewById(R.id.date)
        var icon: ImageView = parent.findViewById(R.id.icon_img)
        var container: ConstraintLayout = parent.findViewById(R.id.container)

        companion object {
            fun creat(parent: ViewGroup): ViewHolder {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item, parent, false)
                return ViewHolder(itemView)
            }
        }

        fun bind(diary: Diary) {
            title.text = diary.title
            date.text = convertLongToDateString(diary.date)
            icon.setImageResource(R.drawable.ic_image)
            container.setOnClickListener { v ->
                val action =
                    HomeFragmentDirections.actionHomeFragmentToDiaryDetailsFragment(
                        diary.pk
                    )
                Navigation.findNavController(v).navigate(action)
            }
        }
    }

}