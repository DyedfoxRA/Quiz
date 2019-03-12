package com.dyedfox.quiz.data.entity.question

import android.util.Log
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson


class QuestionDataTypeConverter {



        private val gson = Gson()

        @TypeConverter
        fun stringToQuestion(json: String): List<Question> {
            val listType = object : TypeToken<List<Question>>() {

            }.type
            Log.e("QQ",json)
            return gson.fromJson(json,listType)
        }

        @TypeConverter
        fun questionToString(question: List<Question>): String {
            return gson.toJson(question)
        }



}