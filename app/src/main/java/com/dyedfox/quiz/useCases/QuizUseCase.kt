package com.dyedfox.quiz.useCases

import android.content.Context
import android.util.Log
import com.dyedfox.quiz.data.entity.question.QuestionResponse

class QuizUseCase(_context: Context) : BaseUseCase(_context) {

    suspend fun getQuizQuestion(id: Long): QuestionResponse {
        return if (checkNetworkConnection()) {
            val resp = getNetworkHelper().client.getQuiz(id).await().body()
            Log.e("res3", resp.toString())
            if (resp != null) {
                getDb().saveQuestionResponse(resp)
            } else
                Log.e("res1",getDb().getQuestionResponse(id).toString())
                getDb().getQuestionResponse(id)

        } else
            getDb().getQuestionResponse(id)
    }
}