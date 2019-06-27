package com.esi.mydiary.fragments.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esi.mydiary.db.DiaryDatabseDAO
import java.lang.IllegalArgumentException

class HomeViewModelFactory(
    private val datasource: DiaryDatabseDAO,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {

            return HomeViewModel(datasource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}