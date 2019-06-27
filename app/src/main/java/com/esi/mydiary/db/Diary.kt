package com.esi.mydiary.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="Dairies_table")
data class Diary(
    @PrimaryKey(autoGenerate = true)
    var pk: Int = 0,
    var title: String,
    var img: String,
    var content: String,
    var date: Long = System.currentTimeMillis()
) {
}