package com.dyedfox.quiz.data.entity.quiz

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "quizzes")
data class Item(
    var buttonStart: String? = null,
    @Ignore
    var categories: List<Category>? = null,
    @Ignore
    var category: Category? = null,
    var content: String? = null,
    var createdAt: String? = null,
    @PrimaryKey
    var id: Long? = null,
    @Ignore
    var mainPhoto: MainPhoto? = null,
    var questions: Int? = null,
    var shareTitle: String? = null,
    var sponsored: Boolean? = null,
    @Ignore
    var tags: List<Tag>? = null,
    var title: String? = null,
    var type: String? = null
)