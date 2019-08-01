package br.com.wab.equest_app_mvvm.model.repository

import br.com.wab.equest_app_mvvm.model.Survey
import br.com.wab.equest_app_mvvm.model.Template
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface SurveyRepository {

    @POST
    fun add(@Body survey: Survey): Deferred<Survey>

    @GET("/survey/getAll")
    fun getAllSurveys(@Query("offset")offset:Int, @Query("limit")limit:Int): Deferred<MutableList<Survey>>


}