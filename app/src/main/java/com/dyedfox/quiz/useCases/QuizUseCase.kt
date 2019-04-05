package com.dyedfox.quiz.useCases

import com.dyedfox.quiz.data.entity.question.QuestionResponse
import com.dyedfox.quiz.utils.NetworkHelper

class QuizUseCase() : BaseUseCase() {

    suspend fun getQuizQuestion(id: Long): QuestionResponse {
        return if (checkNetworkConnection()) {

            NetworkHelper
                .getClient()
                .getQuiz(id)
                .await()
                .let {
                    return when (it.code()) {
                        200 -> it.body()!!
                        else -> getDb().getQuestionResponse(id)
                    }
                }
        } else getDb().getQuestionResponse(id)


    }
}