package com.esi.mydiary.fragments.addDiary

import android.util.Log
import androidx.lifecycle.ViewModel
import com.esi.mydiary.db.Diary
import com.esi.mydiary.db.DiaryDatabseDAO
import kotlinx.coroutines.*

class AddDiaryViewModel(
    private val datasource: DiaryDatabseDAO
) : ViewModel() {

    private val job = Job()
    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + job)


    fun addDiary(title: String, content: String, img: Int) {
        var diary = Diary(title = title, content = content, img = img)
        Log.i("AddDiaryViewModel", "${diary.title} : \n${diary.content}")
        insert(diary)
    }

    private fun insert(diary: Diary) {
        uiScope.launch {
            insertIntoDB(diary)
        }
    }

    private suspend fun insertIntoDB(diary: Diary) {
        withContext(Dispatchers.IO) {
            datasource.insert(diary)
        }
    }
}
