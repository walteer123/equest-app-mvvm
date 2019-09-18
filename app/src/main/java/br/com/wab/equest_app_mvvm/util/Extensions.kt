package br.com.wab.equest_app_mvvm.util

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<MutableList<T>>.add(item: T){
    //usado para notificar observer quando item da lista for adicionado
    val updatedItems = this.value as MutableList
    updatedItems.add(item)
    this.value = updatedItems
}