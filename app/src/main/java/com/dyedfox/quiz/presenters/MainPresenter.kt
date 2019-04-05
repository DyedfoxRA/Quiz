package com.dyedfox.quiz.presenters

import android.util.Log
import com.dyedfox.quiz.useCases.MainUseCase
import com.dyedfox.quiz.view.interfaces.MainView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter() : BasePresenter() {
    private val mainUseCase = MainUseCase()

    var mainView: MainView? = null

    fun getQuizzles() {
        launch {

            mainUseCase.getQuizResponse().let {
                withContext(Dispatchers.Main)
                {
                    if (it.isNullOrEmpty()) {
                        if (mainView != null)
                            mainView!!.listIsNull()
                    } else {
                        Log.e("ListSize", it.size.toString())
                        if (mainView != null)
                            mainView!!.getQuizSuccess(it)
                    }
                }
            }

        }
    }


}