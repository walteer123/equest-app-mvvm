package br.com.wab.equest_app_mvvm.model.repository.config

import br.com.wab.equest_app_mvvm.model.repository.QuestionRepository
import br.com.wab.equest_app_mvvm.model.repository.SurveyRepository
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Connection {

    private const val BASE_URL = "http://10.255.63.208:8080"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
    }


    val surveyRepository: SurveyRepository? = retrofit.create(SurveyRepository::class.java)

    val questionRepository: QuestionRepository? = retrofit.create(QuestionRepository::class.java)

}