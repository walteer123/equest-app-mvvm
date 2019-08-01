package br.com.wab.equest_app_mvvm.model

import java.io.Serializable

class Question(var title: String, var type : QuestionType?, var required: Boolean = false): Serializable {
    var id: String? = null
    var options: MutableList<String> = ArrayList()
}

enum class QuestionType{
    TEXT,
    TEXTAREA,
    NUMBER,
    SELECT,
    CHECKBOX,
    RADIO
}