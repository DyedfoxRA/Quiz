package com.dyedfox.quiz.useCases

import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.ContextCompat
import com.dyedfox.quiz.data.entity.quiz.Item
import com.dyedfox.quiz.data.entity.quiz.QuizResponse
import com.dyedfox.quiz.repo.network.NetworkHelper
import java.lang.Exception

class MainUseCase(context_: Context) : BaseUseCase(context_) {


    suspend fun getQuizResponse(): List<Item> {
        return try {
            val resp = getNetworkHelper().client.getListQuizzes().await().body()?.items
            if (resp != null) {
                getDb().saveItem(resp)
                resp
            } else
                getDb().getQuiezzes()
        } catch (e: Exception) {
            getDb().getQuiezzes()
        }
    }


}