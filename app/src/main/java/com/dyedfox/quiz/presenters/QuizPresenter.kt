package com.dyedfox.quiz.presenters

import com.dyedfox.quiz.QuizActivity
import com.dyedfox.quiz.data.entity.question.Question
import com.dyedfox.quiz.useCases.QuizUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuizPresenter(val activity: QuizActivity) : BasePresenter() {

    private val quizUseCase = QuizUseCase(activity)

    private val listOfQuizQuestio = ArrayList<Question>()

    fun getQuiz(id : Long) {
        launch {


            quizUseCase.getQuizQuestion(id).let {
                if (it != null) {
                    listOfQuizQuestio.addAll(it.questions!!)
                    withContext(Dispatchers.Main)
                    {
                        initFields(it.lastQuestionId)
                    }
                }
            }
        }

    }

    private fun initFields(lastQuestionId: Int) {
        activity.setTextOfQuestion(listOfQuizQuestio[lastQuestionId].text)
    }


}