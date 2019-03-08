package com.dyedfox.quiz.data.entity.question

import androidx.room.*

@Entity(tableName = "questions_responce")
data class QuestionResponse(

    var avgResult: Double? = null,
    var buttonStart: String? = null,
    @Ignore
    var categories: List<Category>? = null,
    @Ignore
    var category: Category? = null,
    @Ignore
    var celebrity: Celebrity? = null,
    @Ignore
    var cityAvg: Any? = null,
    @Ignore
    var cityCount: Any? = null,
    @Ignore
    var cityTime: Any? = null,
    var content: String? = null,
    var created: Int? = null,
    var createdAt: String? = null,
    @PrimaryKey
    var id: Long? = null,
    var isBattle: Boolean? = null,
    @Ignore
    var latestResults: List<LatestResult>? = null,
    @Ignore
    var mainPhoto: MainPhoto? = null,
    var questions: List<Question>? = null,
    var lastQuestionId: Int = 0,
    @Ignore
    var rates: List<Rate>? = null,
    var resultCount: Int? = null,
    var scripts: String? = null,
    var shareTitle: String? = null,
    var sponsored: Boolean? = null,
    @Ignore
    var sponsoredResults: SponsoredResults? = null,
    @Ignore
    var tags: List<Tag>? = null,
    var title: String? = null,
    var type: String? = null,
    var userBattleDone: Boolean? = null
)