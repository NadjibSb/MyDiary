package com.esi.mydiary.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.esi.mydiary.R

class AddDiaryFragment : Fragment() {

    companion object {
        fun newInstance() = AddDiaryFragment()
    }

    private lateinit var viewModel: AddDiaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_diary_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddDiaryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
