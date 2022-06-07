package com.gb.m_1975_3.viewmodel

import com.gb.m_1975_3.model.PictureOfTheDayServerResponseData

sealed class AppState{
    data class Success(val serverResponseData: PictureOfTheDayServerResponseData) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}
