package com.dyedfox.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
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

        quizPresenter.getQuiz(intent.extras.getLong("id"))

        next_question_button.setOnClickListener{
            quizPresenter.doWhenButton1isClicked()
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
        Glide
            .with(this)
            .load(name)
            .apply(RequestOptions().override(600, 300).centerCrop())
            .into(question_image)
    }

    fun  cleanView()
    {
        text_question.text = "Question"
        answers_radio_group.removeAllViews()

    }


}
