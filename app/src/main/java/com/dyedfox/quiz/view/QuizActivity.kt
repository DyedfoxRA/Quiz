package com.dyedfox.quiz.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dyedfox.quiz.R
import com.dyedfox.quiz.data.entity.question.Answer
import com.dyedfox.quiz.data.entity.question.Question
import com.dyedfox.quiz.presenters.QuizPresenter
import com.dyedfox.quiz.view.interfaces.QuizView
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity(), QuizView {


    private val listOfQuizQuestio = ArrayList<Question>()

    private var indexOfQuestion = 0;

    private val quizPresenter = QuizPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        supportActionBar?.title = "Questions"
        quizPresenter.getQuiz(intent.extras.getLong("id"))

        next_question_button.setOnClickListener {
            doNextIsClicked()
        }

    }


    fun setAnswersOfQuestion(list: List<Answer>) {
        for (ans in list) {
            val radioButton = RadioButton(this)
            radioButton.text = ans.text
            answers_radio_group.addView(radioButton)
        }
    }

    fun setTextOfQuestion(text: String) {
        text_question.text = text
    }

    fun setImageOfQuestion(name: String) {
        if (name.isEmpty())
            question_image.visibility = View.GONE
        else {
            question_image.visibility = View.VISIBLE
            Glide
                .with(this)
                .load(name)
                .apply(RequestOptions().override(600, 600).centerCrop())
                .into(question_image)
        }
    }

    fun cleanView() {
        setTextOfQuestion("Question")
        answers_radio_group.removeAllViews()
        setImageOfQuestion("")
    }

    fun updateProgress(progress: Int) {

        quiz_progressBar.progress = progress
    }

    private fun initFields(lastQuestionId: Int) {
        setTextOfQuestion(listOfQuizQuestio[lastQuestionId].text)
        setAnswersOfQuestion(listOfQuizQuestio[lastQuestionId].answers)
        setImageOfQuestion(listOfQuizQuestio[lastQuestionId].image.url)
    }

    private fun goToMainView() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("id", indexOfQuestion)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }


    fun doNextIsClicked() {
        cleanView()
        ++indexOfQuestion
        if (indexOfQuestion <= listOfQuizQuestio.size - 1) {
            if (indexOfQuestion == listOfQuizQuestio.size - 1)
                next_question_button.text = "FINISH"

            initFields(indexOfQuestion)

            updateProgress(
                Math.round(
                    indexOfQuestion / (listOfQuizQuestio.size - 1)
                        .toDouble() * 100
                )
                    .toInt()
            )


        } else
            goToMainView()
        // do whatever business requires
    }
    override fun getQuestionSuccess(it: List<Question>) {

    }


}
