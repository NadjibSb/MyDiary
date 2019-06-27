package com.esi.mydiary.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import com.esi.mydiary.R
import com.esi.mydiary.databinding.DiaryDetailsFragmentBinding
import com.esi.mydiary.db.DiaryDatabase
import com.esi.mydiary.db.DiaryDatabseDAO

class DiaryDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = DiaryDetailsFragment()
    }

    private lateinit var viewModel: DiaryDetailsViewModel
    private lateinit var binding:  DiaryDetailsFragmentBinding
    private lateinit var args: DiaryDetailsFragmentArgs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.diary_details_fragment,container,false)
        args = DiaryDetailsFragmentArgs.fromBundle(arguments!!)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val application = requireNotNull(activity).application
        val datasource = DiaryDatabase.getInstance(application).diaryDatabseDAO
        val factory = DiaryDetailsViewModelFactory(args.diaryID, datasource,application)
        viewModel = ViewModelProviders.of(this,factory).get(DiaryDetailsViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.dairy.observe(this, Observer { diary->
            binding.apply {
                title.text = diary.title
                date.text = diary.date.toString()
                content.text = diary.content
            }
        })
        // TODO: Use the ViewModel
    }

}
