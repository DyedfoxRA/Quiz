package com.dyedfox.quiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dyedfox.quiz.presenters.MainPresenter

class MainActivity : AppCompatActivity() {

    private val mainPresenter = MainPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()

    }

    fun initRecycler() {
        mainPresenter.initRecycler()
    }


}
