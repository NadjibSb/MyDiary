package com.esi.mydiary.fragments.home

import androidx.lifecycle.ViewModel
import com.esi.mydiary.db.DiaryDatabseDAO

class HomeViewModel(
    datasource: DiaryDatabseDAO
) : ViewModel() {

    var dairies = datasource.getDiaries()


}
