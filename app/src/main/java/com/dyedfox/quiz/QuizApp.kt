package com.dyedfox.quiz

import android.app.Application
import com.dyedfox.quiz.repo.network.NetworkHelper

class QuizApp : Application() {


companion object {
    var networkHelper: NetworkHelper? = null
}

    override fun onCreate() {
        super.onCreate()
    }
}