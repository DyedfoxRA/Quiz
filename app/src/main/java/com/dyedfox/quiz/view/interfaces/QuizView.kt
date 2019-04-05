package com.dyedfox.quiz.view.interfaces

import com.dyedfox.quiz.data.entity.question.Question

interface QuizView {

    fun getQuestionSuccess(it: List<Question>)
}