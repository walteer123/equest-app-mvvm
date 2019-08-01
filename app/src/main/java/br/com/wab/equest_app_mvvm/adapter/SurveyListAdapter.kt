package br.com.wab.equest_app_mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import br.com.wab.equest_app_mvvm.R
import br.com.wab.equest_app_mvvm.model.Survey
import br.com.wab.equest_app_mvvm.model.Template
import kotlinx.android.synthetic.main.item_template_list.view.*


class SurveyListAdapter(private val items: MutableList<Survey>, private val callback: Callback):
    RecyclerView.Adapter<SurveyListAdapter.ViewHolder>() {

    class ViewHolder(val layout: LinearLayout): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_template_list, parent, false) as LinearLayout

        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.layout.item_template_name.text = items[position].name
        holder.layout.item_template_desc.text = items[position].description

        holder.layout.item_edit_template.setOnClickListener {
            callback.onClickEdit(position)
        }
        holder.layout.item_answers_template.setOnClickListener {
            callback.onClickAnswers(position)
        }
        holder.layout.item_delete_template.setOnClickListener {
            callback.onClickDelete(position)
        }

        if(items[position].answers.isEmpty()){
            holder.layout.item_answers_template.visibility = View.GONE
            holder.layout.item_edit_template.visibility = View.GONE
        }else{
            holder.layout.item_answers_template.visibility = View.VISIBLE
            holder.layout.item_edit_template.visibility = View.VISIBLE
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface Callback{

        fun onClickEdit(position: Int)

        fun onClickDelete(position: Int)

        fun onClickAnswers(position: Int)

    }
}