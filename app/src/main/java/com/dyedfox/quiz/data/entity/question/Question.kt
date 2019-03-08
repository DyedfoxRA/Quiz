package com.dyedfox.quiz.data.entity.question

import androidx.room.Entity


data class Question(

    val answer: String,
    val answers: List<Answer>,
    val image: Image,
    val order: Int,
    val text: String,
    val type: String

)