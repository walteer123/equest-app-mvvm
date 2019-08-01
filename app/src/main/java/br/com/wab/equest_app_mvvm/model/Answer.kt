package br.com.wab.equest_app_mvvm.model

import java.util.*

class Answer {

    var id: String? = null
    var question: Question? = null

    var value: String? = null
    var values: MutableList<String> = ArrayList()
}