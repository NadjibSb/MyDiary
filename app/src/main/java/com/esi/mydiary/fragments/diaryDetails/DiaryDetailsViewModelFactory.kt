package com.esi.mydiary.fragments.diaryDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esi.mydiary.db.DiaryDatabseDAO

class DiaryDetailsViewModelFactory(
    val diaryID: Int,
    val datasource: DiaryDatabseDAO
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiaryDetailsViewModel::class.java)) {
            return DiaryDetailsViewModel(diaryID, datasource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}