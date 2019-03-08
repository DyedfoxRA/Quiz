package com.dyedfox.quiz.repo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.dyedfox.quiz.data.entity.question.QuestionResponse
import com.dyedfox.quiz.data.entity.quiz.Item
import kotlinx.coroutines.Deferred

@Dao
interface Dao {

    @Query("SELECT * FROM quizzes")
    suspend fun getQuiezzes(): List<Item>

    @Query("SELECT * FROM questions_responce where id = :id limit 1")
    suspend fun getQuestionResponse(id: Long): QuestionResponse

    @Insert(onConflict = REPLACE)
    fun saveQuestionResponse(questionResponse: QuestionResponse)

    @Insert(onConflict = REPLACE)
    fun saveItem(item: List<Item>)
}