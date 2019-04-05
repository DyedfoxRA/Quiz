package com.dyedfox.quiz.view.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.quiz_item.view.*

class RecyclerViewQuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var title_quiz: TextView = itemView.title_quiz

    private var image_quiz: ImageView = itemView.image_quiz

    private var card_view_quiz: CardView = itemView.card_view_quiz

    fun getCardViewOfQuiz() = card_view_quiz

    fun getTitleOfQuiz() = title_quiz

    fun getImageOfQuiz() = image_quiz


}
