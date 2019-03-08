package com.dyedfox.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dyedfox.quiz.presenters.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

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
