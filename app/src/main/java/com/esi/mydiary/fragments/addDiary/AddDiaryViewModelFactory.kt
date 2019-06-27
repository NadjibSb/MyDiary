package com.esi.mydiary.fragments.addDiary

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esi.mydiary.db.DiaryDatabseDAO
import java.lang.IllegalArgumentException

class AddDiaryViewModelFactory(
    private val datasource: DiaryDatabseDAO,
    private val application: Application
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddDiaryViewModel::class.java)){
            return AddDiaryViewModel(datasource, application) as T
        }
        throw IllegalArgumentException("unknown ViewModel class")
    }
}