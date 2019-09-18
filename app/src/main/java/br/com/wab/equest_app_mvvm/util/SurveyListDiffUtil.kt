package br.com.wab.equest_app_mvvm.util

import androidx.recyclerview.widget.DiffUtil
import br.com.wab.equest_app_mvvm.model.Survey

class SurveyListDiffUtil(private val oldList: MutableList<Survey>, private val newList: MutableList<Survey>)
    : DiffUtil.Callback() {


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList.get(oldItemPosition).id == newList.get(newItemPosition).id
    }

    override fun getOldListSize(): Int {
       return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition))
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}