package com.dyedfox.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dyedfox.quiz.presenters.QuizPresenter
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private val quizPresenter = QuizPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        quizPresenter.getQuiz(intent.extras.getLong("id"))

    }


    fun setTextOfQuestion(text: String) {
        text_question.text = text
    }
}
