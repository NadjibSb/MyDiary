package com.esi.mydiary.fragments

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.esi.mydiary.db.Diary
import com.esi.mydiary.db.DiaryDatabseDAO
import kotlinx.coroutines.*

class HomeViewModel(
    val datasource: DiaryDatabseDAO,
    application: Application) : ViewModel() {
    // TODO: Implement the ViewModel

    private val job = Job()

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + job)
    private var dairy = MutableLiveData<Diary>()
    var dairies = MutableLiveData<List<Diary>>()

    init {
        //firstInsert()
        uiScope.launch {
            dairies.value = getAllDairies()
        }
    }

    private suspend fun getAllDairies(): List<Diary>? {
        return withContext(Dispatchers.IO){
            datasource.getDiaries()
        }
    }

    private fun firstInsert() {
        uiScope.launch {
            for (i in 1..10){
                val diary = Diary(
                    title = "Title $i",
                    img = "",
                    content = "This is just an example. This is just an example. This is just an example. This is just an example. This is just an example. This is just an example. "
                )
                insert(diary)
            }
        }
    }

    private suspend fun insert(diary: Diary){
        withContext(Dispatchers.IO){
            datasource.insert(diary)
        }
    }


}
