package com.dyedfox.quiz.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dyedfox.quiz.R
import com.dyedfox.quiz.data.entity.quiz.Item
import com.dyedfox.quiz.presenters.MainPresenter
import com.dyedfox.quiz.view.adapters.RecyclerViewQuizAdapter
import com.dyedfox.quiz.view.interfaces.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var adapter: RecyclerViewQuizAdapter

    private val mainPresenter = MainPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter.mainView = this
        initRecycler()
        mainPresenter.getQuizzles()

    }


    fun initRecycler() {
        adapter = RecyclerViewQuizAdapter(ArrayList(), this)
        recycler_view_quiz.layoutManager = LinearLayoutManager(this)
        recycler_view_quiz.adapter = adapter
        //getQuizzles()
    }

    override fun listIsNull() {
        adapter.listOfItems.clear()
        adapter.notifyDataSetChanged()
    }

    override fun getQuizSuccess(it: List<Item>) {
        adapter.listOfItems.clear()
        adapter.listOfItems.addAll(it)
        adapter.notifyDataSetChanged()

    }

}
