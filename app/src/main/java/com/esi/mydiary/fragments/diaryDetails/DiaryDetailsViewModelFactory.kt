package com.esi.mydiary.fragments.diaryDetails

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esi.mydiary.db.DiaryDatabseDAO
import java.lang.IllegalArgumentException

class DiaryDetailsViewModelFactory(
    val diaryID: Int,
    val datasource: DiaryDatabseDAO,
    val application: Application
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiaryDetailsViewModel::class.java)){
            return DiaryDetailsViewModel(diaryID, datasource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}