package com.esi.mydiary.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DiaryDatabseDAO {
    @Insert
    fun insert(diary: Diary)

    @Update
    fun update(diary: Diary)

    @Query("SELECT * FROM Dairies_table ORDER BY date DESC")
    fun getDiaries(): LiveData<List<Diary>>

    @Query("SELECT * FROM Dairies_table WHERE pk = :id")
    fun getDiary(id: Int): Diary

    @Delete
    fun delete(diary: Diary)
}