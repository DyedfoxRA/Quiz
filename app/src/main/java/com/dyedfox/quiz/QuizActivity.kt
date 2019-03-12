package com.dyedfox.quiz

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dyedfox.quiz.data.entity.question.Answer
import com.dyedfox.quiz.presenters.QuizPresenter
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private val quizPresenter = QuizPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        supportActionBar?.title = "Questions"
        quizPresenter.getQuiz(intent.extras.getLong("id"))

            next_question_button.setOnClickListener{
            quizPresenter.doNextButton1isClicked()
        }

    }


    fun setAnswersOfQuestion(list: List<Answer>)
    {
        for(ans in list) {
            val radioButton = RadioButton(this)
            radioButton.text = ans.text
            answers_radio_group.addView(radioButton)
        }
    }
    fun setTextOfQuestion(text: String) {
        text_question.text = text
    }

    fun setImageOfQuestion(name: String)
    {
        if(name.isEmpty())
            question_image.visibility = View.GONE
        else
        Glide
            .with(this)
            .load(name)
            .apply(RequestOptions().override(600, 600).centerCrop())
            .into(question_image)
    }

    fun  cleanView()
    {
        setTextOfQuestion("Question")
        answers_radio_group.removeAllViews()
        setImageOfQuestion("")
    }

    fun updateProgress(progress: Int)
    {
        Log.e("progressBar",progress.toString())
        quiz_progressBar.progress = progress
    }


}
