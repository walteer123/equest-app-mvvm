package br.com.wab.equest_app_mvvm.model

import java.io.Serializable

class Survey(val name:String, val description: String, val answers: MutableList<Answer>, val template: Template):
    Serializable {
    var id: String? = null

    var url: String? = null
}