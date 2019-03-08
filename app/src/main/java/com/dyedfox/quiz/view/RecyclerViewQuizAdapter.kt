package com.dyedfox.quiz.view

import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dyedfox.quiz.data.entity.quiz.Item
import com.dyedfox.quiz.data.entity.quiz.QuizResponse
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dyedfox.quiz.QuizActivity
import com.dyedfox.quiz.R
import kotlinx.android.synthetic.main.quiz_item.view.*


class RecyclerViewQuizAdapter(val listOfItems: List<Item>, val context: Context) :
    RecyclerView.Adapter<RecyclerViewQuizViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewQuizViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecyclerViewQuizViewHolder(layoutInflater.inflate(R.layout.quiz_item, parent, false))
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }

    override fun onBindViewHolder(holder: RecyclerViewQuizViewHolder, position: Int) {
        val item = listOfItems[position]
        holder.getTitleOfQuiz().let {
            it.text = item.title
        }
        holder.getImageOfQuiz().let {

            Glide
                .with(context)
                .load(item.mainPhoto?.url)
                .apply(RequestOptions().override(600, 200).centerCrop())
                .into(it)

        }

        holder.getCompleteOfQuiz().let {
            it.text = "80%"
        }

        holder.getResultOfQuiz().let {
            it.text = "8/10"
        }

        holder.getCardViewOfQuiz().setOnClickListener {
            val intent = Intent(context, QuizActivity::class.java)
            intent.putExtra("id", item.id)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)

        }
    }

}