package br.com.wab.equest_app_mvvm.model.repository

import br.com.wab.equest_app_mvvm.model.Question
import br.com.wab.equest_app_mvvm.model.Survey
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.POST

interface QuestionRepository {

    @POST("/question/addAll")
    fun add(@Body questions: MutableList<Question>): Deferred<MutableList<Survey>>

}