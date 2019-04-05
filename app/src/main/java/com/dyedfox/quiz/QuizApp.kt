package com.dyedfox.quiz

import android.app.Application
import android.content.Context

class QuizApp : Application() {


    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}