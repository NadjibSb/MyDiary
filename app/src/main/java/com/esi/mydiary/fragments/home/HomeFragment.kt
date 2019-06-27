package com.esi.mydiary.fragments.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.esi.mydiary.db.Diary
import com.esi.mydiary.R
import com.esi.mydiary.databinding.HomeFragmentBinding
import com.esi.mydiary.db.DiaryDatabase


class HomeFragment : Fragment() {

    lateinit var binding: HomeFragmentBinding
    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment,container,false)
        binding.setLifecycleOwner(this)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val application = requireNotNull(activity).application
        val dataSource = DiaryDatabase.getInstance(application).diaryDatabseDAO
        val factory = HomeViewModelFactory(dataSource, application)
        viewModel = ViewModelProviders.of(this,factory).get(HomeViewModel::class.java)




        binding.addBtn.setOnClickListener { view ->
            val action =
                HomeFragmentDirections.actionHomeFragmentToAddDiaryFragment()
            Navigation.findNavController(view).navigate(action)
        }
        viewModel.dairies.observe(this, Observer { list->
            setupRecycleView(list)
        })

    }

    private fun setupRecycleView(list: List<Diary>) {
        var recycleView = binding.recycleView
        var adapter = ItemAdapter(list)
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(context)
        recycleView.setHasFixedSize(true)
    }

    private fun defaultList(): List<Diary> {
        var diaries = mutableListOf<Diary>()
        for (i in 0..10) {
            diaries.add(
                Diary(
                    i,
                    "Title $i",
                    R.id.icon_img,
                    "This is just an example. This is just an example. This is just an example. This is just an example. This is just an example. This is just an example. "
                )
            )
        }
        return diaries
    }

}
