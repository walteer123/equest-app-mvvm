package br.com.wab.equest_app_mvvm.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import br.com.wab.equest_app_mvvm.R
import br.com.wab.equest_app_mvvm.model.Question
import kotlinx.android.synthetic.main.item_question_list.view.*

class QuestionListAdapter(val items: MutableList<Question>): RecyclerView.Adapter<QuestionListAdapter.ViewHolder>() {

    class ViewHolder(val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_question_list, parent, false)

        return ViewHolder(layout)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.layout.text_question_name.text = items[position].title
        holder.layout.text_question_type.text = items[position].type?.value
        if (items[position].required){
            holder.layout.text_question_required.visibility = View.VISIBLE
            holder.layout.text_question_required.text = Resources.getSystem().getString(R.string.required)
        }else{
            holder.layout.text_question_required.visibility = View.GONE
        }
    }
}