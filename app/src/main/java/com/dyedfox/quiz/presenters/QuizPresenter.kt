package com.dyedfox.quiz.presenters

import com.dyedfox.quiz.useCases.QuizUseCase
import com.dyedfox.quiz.view.interfaces.QuizView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuizPresenter() : BasePresenter() {

    private val quizUseCase = QuizUseCase()

    var quizView: QuizView? = null

    fun getQuiz(id: Long) {
        launch {

            quizUseCase.getQuizQuestion(id).let {
                withContext(Dispatchers.Main)
                {

                    if (quizView != null)
                        quizView!!.getQuestionSuccess(it.questions!!)

                }
            }
        }

    }


}