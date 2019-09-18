package br.com.wab.equest_app_mvvm.model

import java.io.Serializable

class Question(var title: String, var type : QuestionType?, var required: Boolean = false): Serializable {
    var id: String? = null
    var options: MutableList<String> = ArrayList()
}

enum class QuestionType(val value: String){
    TEXT("Texto"),
    TEXTAREA( "Área de texto" ),
    NUMBER("Numérico"),
    SELECT("Caixa de seleção"),
    CHECKBOX("Caixa de marcação"),
    RADIO("Botão de opção")
}