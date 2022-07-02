package com.otienosamwel.schedule_notifications

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferences = Preferences(this)

        //start only of the work is not already running
        if (!preferences.isWorkRunning()) {

            startNotificationWork()
            preferences.setWorkRunning(true)
            Toast.makeText(this, "Work started", Toast.LENGTH_LONG).show()
        }
    }


    private fun startNotificationWork() {
        val notificationWorkRequest =
            PeriodicWorkRequestBuilder<NotificationWork>(8, TimeUnit.HOURS).build()
        WorkManager.getInstance(this).enqueue(notificationWorkRequest)
    }
}