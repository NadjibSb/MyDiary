package com.esi.mydiary.fragments

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.esi.mydiary.db.Diary
import com.esi.mydiary.db.DiaryDatabseDAO
import kotlinx.coroutines.*

class DiaryDetailsViewModel(
    val diaryID: Int,
    val datasource: DiaryDatabseDAO,
    application: Application
) : ViewModel() {

    private val job = Job()

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + job)
    var dairy = MutableLiveData<Diary>()

    init {
        uiScope.launch {
            dairy.value = getDiary(diaryID)
        }
    }

    private suspend fun getDiary(id: Int): Diary? {
        return withContext(Dispatchers.IO){
            datasource.getDiary(id)
        }
    }
}
