package com.dyedfox.quiz.data.entity.question

import androidx.room.Ignore

data class Answer(

    val image: Image,
    val isCorrect: Int,
    val order: Int,
    val text: String
)