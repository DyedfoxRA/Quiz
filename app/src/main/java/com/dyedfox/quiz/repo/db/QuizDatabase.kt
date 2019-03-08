package com.dyedfox.quiz.repo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dyedfox.quiz.data.entity.question.QuestionDataTypeConverter

import com.dyedfox.quiz.data.entity.question.QuestionResponse
import com.dyedfox.quiz.data.entity.quiz.Item


@Database(
    entities = [Item::class, QuestionResponse::class],
    version = 1
)
@TypeConverters(QuestionDataTypeConverter::class)
abstract class QuizDatabase : RoomDatabase() {

    abstract fun itemQuizDao(): Dao

    companion object {
        @Volatile
        private var instance: QuizDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                QuizDatabase::class.java, "quiz.db"
            )
                .build()
    }


}