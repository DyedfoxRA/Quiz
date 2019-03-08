package com.dyedfox.quiz.useCases

import android.content.Context
import com.dyedfox.quiz.data.entity.question.QuestionResponse

class QuizUseCase(_context: Context) : BaseUseCase(_context) {

    suspend fun getQuizQuestion(id: Long): QuestionResponse {
        return if (checkNetworkConnection()) {
            val resp = getNetworkHelper().client.getQuiz(id).await().body()
            if (resp != null) {
                getDb().saveQuestionResponse(resp)
                resp
            } else
                getDb().getQuestionResponse(id)

        } else
            getDb().getQuestionResponse(id)
    }
}