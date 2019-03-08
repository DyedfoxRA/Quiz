package com.dyedfox.quiz.presenters

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dyedfox.quiz.MainActivity
import com.dyedfox.quiz.data.entity.quiz.Item
import com.dyedfox.quiz.data.entity.quiz.QuizResponse
import com.dyedfox.quiz.useCases.MainUseCase
import com.dyedfox.quiz.view.RecyclerViewQuizAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(val activity: MainActivity) : BasePresenter() {
    private val mainUseCase = MainUseCase(activity)

    private val listOfQuizResponse = ArrayList<Item>()

    private lateinit var adapter: RecyclerViewQuizAdapter

    fun getQuizzles() {
        launch {


            mainUseCase.getQuizResponse().let {
                if (it != null) {
                    listOfQuizResponse.addAll(it)
                    withContext(Dispatchers.Main)
                    {
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }

    }

    fun initRecycler() {
        adapter = RecyclerViewQuizAdapter(listOfQuizResponse, activity)
        activity.recycler_view_quiz.layoutManager = LinearLayoutManager(activity)
        activity.recycler_view_quiz.adapter = adapter
        getQuizzles()


    }

}