package com.esi.mydiary.fragments.addDiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.esi.mydiary.MainActivity
import com.esi.mydiary.R
import com.esi.mydiary.databinding.AddDiaryFragmentBinding
import com.esi.mydiary.db.DiaryDatabase

class AddDiaryFragment : Fragment() {

    companion object {
        fun newInstance() = AddDiaryFragment()
    }

    private lateinit var viewModel: AddDiaryViewModel
    private lateinit var binding: AddDiaryFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.add_diary_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val application = requireNotNull(activity).application
        val datasource = DiaryDatabase.getInstance(application).diaryDatabseDAO
        val factory = AddDiaryViewModelFactory(datasource, application)
        viewModel = ViewModelProviders.of(this, factory).get(AddDiaryViewModel::class.java)

        binding.addBtn.setOnClickListener { btn ->
            binding.apply {
                if (title.text.toString().isEmpty()) {
                    Toast.makeText(context, "Please, Enter a Title", Toast.LENGTH_SHORT).show()
                } else {
                    if (content.text.toString().isEmpty()) {
                        Toast.makeText(context, "Please, Enter the content of your Diary", Toast.LENGTH_SHORT).show()
                    } else {
                        viewModel.addDiary(title.text.toString(),content.text.toString(),R.drawable.ic_image)
                        Toast.makeText(context,"Diary successfully added",Toast.LENGTH_SHORT).show()
                        var navController = (requireNotNull(activity) as MainActivity).navController
                        navController.navigateUp()
                    }
                }
            }

        }
    }

}
