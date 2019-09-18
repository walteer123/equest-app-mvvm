package br.com.wab.equest_app_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.wab.equest_app_mvvm.model.Question
import br.com.wab.equest_app_mvvm.model.repository.config.Connection
import kotlinx.coroutines.*

class SurveyViewModel: ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main+viewModelJob)

    private val questionRepository = Connection.questionRepository

    val questionListLiveData = MutableLiveData<MutableList<Question>>()

    fun addQuestions(questions:MutableList<Question>) = runBlocking {
        val result = async {
            questionRepository?.add(questions)?.await()!!
        }
        return@runBlocking result.await()
    }

}