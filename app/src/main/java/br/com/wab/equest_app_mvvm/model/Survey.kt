package br.com.wab.equest_app_mvvm.model

import java.io.Serializable

class Survey(val name: String, val description: String, val questions: MutableList<Question>,val answers: MutableList<Answer>):
    Serializable {
    var id: String? = null

    var url: String? = null
}