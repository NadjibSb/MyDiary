package com.esi.mydiary.fragments.addDiary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esi.mydiary.db.DiaryDatabseDAO

class AddDiaryViewModelFactory(
    private val datasource: DiaryDatabseDAO
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddDiaryViewModel::class.java)) {
            return AddDiaryViewModel(datasource) as T
        }
        throw IllegalArgumentException("unknown ViewModel class")
    }
}