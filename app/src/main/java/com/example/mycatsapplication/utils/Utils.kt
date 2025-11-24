package com.example.mycatsapplication.utils

class Utils() {

    companion object {
        fun getCatSharedPreferences(): String {
            return THE_CAT_SHARED_PREFERENCES
        }

        private const val THE_CAT_SHARED_PREFERENCES: String =
            "cat_shared_preferences"
    }

}