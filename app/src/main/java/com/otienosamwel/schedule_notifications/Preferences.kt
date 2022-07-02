package com.otienosamwel.schedule_notifications

import android.content.Context
import androidx.core.content.edit

class Preferences(context: Context) {
    //create a share preference object

    private val preferences = context.getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)

    fun isWorkRunning(): Boolean {
        return preferences.getBoolean("notification_work", false)
    }

    fun setWorkRunning(running: Boolean) {
        preferences.edit {
            putBoolean("notification_work", running)
        }
    }


}