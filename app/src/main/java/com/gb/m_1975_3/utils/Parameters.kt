package com.gb.m_1975_3.utils

import com.gb.m_1975_3.R

class Parameters {
    var resetFragment: Boolean = false
    var theme: Int = R.style.MyBlueTheme

    companion object {

        @Volatile
        private var INSTANCE: Parameters? = null
        fun getInstance(): Parameters {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Parameters()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}
