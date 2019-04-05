package com.dyedfox.quiz.useCases

import android.content.Context
import android.net.ConnectivityManager
import com.dyedfox.quiz.QuizApp.Companion.context
import com.dyedfox.quiz.repo.db.Dao
import com.dyedfox.quiz.repo.db.QuizDatabase

open class BaseUseCase() {


    /*   fun getNetworkHelper(): NetworkHelper {
           if (networkHelper == null)
               networkHelper = NetworkHelper()

           return networkHelper!!
       }*/

    fun getDb(): Dao {

        return QuizDatabase.invoke(context!!).itemQuizDao()
    }

    fun checkNetworkConnection(): Boolean {
        val connectivityManager = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}