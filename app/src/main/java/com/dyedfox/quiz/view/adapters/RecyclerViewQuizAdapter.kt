package com.dyedfox.quiz.view.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dyedfox.quiz.R
import com.dyedfox.quiz.data.entity.quiz.Item
import com.dyedfox.quiz.view.QuizActivity


class RecyclerViewQuizAdapter(val listOfItems: ArrayList<Item>, val context: Context) :
    RecyclerView.Adapter<RecyclerViewQuizViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewQuizViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecyclerViewQuizViewHolder(
            layoutInflater.inflate(
                R.layout.quiz_item,
                parent,
                false
            )
        )
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
            //.override(300, 200)

             var ro = RequestOptions()
                 .centerCrop()
                 .transforms(CenterCrop(), RoundedCorners(16))
             Glide
                 .with(context)
                 .load(item.mainPhoto?.url)
                 .apply(ro)
                 .into(it)


        }

        holder.getCardViewOfQuiz().setOnClickListener {
            val intent = Intent(context, QuizActivity::class.java)
            intent.putExtra("id", item.id)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)

        }
    }

}