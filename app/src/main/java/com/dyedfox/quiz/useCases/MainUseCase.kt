package com.dyedfox.quiz.useCases

import com.dyedfox.quiz.data.entity.quiz.Item
import com.dyedfox.quiz.utils.NetworkHelper

class MainUseCase() : BaseUseCase() {


    suspend fun getQuizResponse(): List<Item>? {
        return try {
            NetworkHelper
                .getClient()
                .getListQuizzes()
                .await()
                .let {
                    return when (it.code()) {
                        200 -> it.body()?.items
                        else -> getDb().getQuiezzes()
                    }

                }
            // getDb().saveItem(it.body()?.items)
        } catch (e: Exception) {
            getDb().getQuiezzes()
        }
    }


}