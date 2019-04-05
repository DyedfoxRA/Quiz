package com.dyedfox.quiz.view.interfaces

import com.dyedfox.quiz.data.entity.quiz.Item

interface MainView {
    fun listIsNull()
    fun getQuizSuccess(it: List<Item>)
}