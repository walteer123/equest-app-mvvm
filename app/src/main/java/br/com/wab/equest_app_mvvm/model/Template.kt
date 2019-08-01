package br.com.wab.equest_app_mvvm.model

import java.io.Serializable

class Template(var name: String, var description: String, var questions: MutableList<Question>, var createdBy: String):Serializable {

    var id: String? = null

    var surveyUrl: String? = ""

}