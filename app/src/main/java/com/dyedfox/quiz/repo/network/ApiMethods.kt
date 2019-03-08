package com.dyedfox.quiz.repo.network

import com.dyedfox.quiz.data.entity.question.QuestionResponse
import com.dyedfox.quiz.data.entity.quiz.QuizResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiMethods {

    @GET("quizzes/0/100")
    fun getListQuizzes(): Deferred<Response<QuizResponse>>

    @GET("quiz/{id_quiz}/0")
    fun getQuiz(@Path("id_quiz") id_quiz: Long): Deferred<Response<QuestionResponse>>


}