package com.dyedfox.quiz.data.entity.question

import com.google.gson.annotations.SerializedName

data class LatestResult(
    val city: Int,
    @SerializedName("end_date")
    val endDate: String,
    val resolveTime: Long,
    val result: Double
)