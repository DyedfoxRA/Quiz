package com.dyedfox.quiz.presenters

import android.content.Intent
import android.util.Log
import com.dyedfox.quiz.MainActivity
import com.dyedfox.quiz.QuizActivity
import com.dyedfox.quiz.data.entity.question.Question
import com.dyedfox.quiz.useCases.QuizUseCase
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.function.IntToDoubleFunction

class QuizPresenter(val activity: QuizActivity) : BasePresenter() {

    private val quizUseCase = QuizUseCase(activity)

    private val listOfQuizQuestio = ArrayList<Question>()

    private var indexOfQuestion = 0;

    fun getQuiz(id : Long) {
        launch {


            quizUseCase.getQuizQuestion(id).let {
                if (it != null) {
                    listOfQuizQuestio.addAll(it.questions!!)
                    withContext(Dispatchers.Main)
                    {
                        initFields(it.lastQuestionId)
                        indexOfQuestion =it.lastQuestionId
                    }
                }
            }
        }

    }

    private fun initFields(lastQuestionId: Int) {
        activity.setTextOfQuestion(listOfQuizQuestio[lastQuestionId].text)
        activity.setAnswersOfQuestion(listOfQuizQuestio[lastQuestionId].answers)
        activity.setImageOfQuestion(listOfQuizQuestio[lastQuestionId].image.url)
    }

    private fun goToMainView()
    {
        val intent = Intent(activity, MainActivity::class.java)
        intent.putExtra("id", indexOfQuestion)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        activity.startActivity(intent)
    }



    fun doNextButton1isClicked() {
        activity.cleanView()
        ++indexOfQuestion
        if(indexOfQuestion<=listOfQuizQuestio.size-1) {
            if (indexOfQuestion == listOfQuizQuestio.size-1)
                activity.next_question_button.text = "FINISH"

            initFields(indexOfQuestion)

            activity.updateProgress(Math.round(indexOfQuestion/(listOfQuizQuestio.size-1)
                .toDouble()*100)
                .toInt())


            }
        else
            goToMainView()
        // do whatever business requires
    }



}