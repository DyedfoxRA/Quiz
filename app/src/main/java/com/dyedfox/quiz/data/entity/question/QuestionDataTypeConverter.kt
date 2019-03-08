package com.dyedfox.quiz.data.entity.question

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson


class QuestionDataTypeConverter {



        private val gson = Gson()



        @TypeConverter
        fun stringToQuestion(json: String): List<Question> {
            val listType = object : TypeToken< List<Question>>() {

            }.type
            return gson.fromJson(json,listType)
        }

        @TypeConverter
        fun questionToString(question: List<Question>): String {
            return gson.toJson(question)
        }



}
