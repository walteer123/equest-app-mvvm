package br.com.wab.equest_app_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.wab.equest_app_mvvm.model.Survey
import br.com.wab.equest_app_mvvm.model.Template
import br.com.wab.equest_app_mvvm.model.repository.config.Connection
import kotlinx.coroutines.*

class DashBoardViewModel : ViewModel() {

    private val repository = Connection.surveyRepository

    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main+viewModelJob)

    val surveyListLiveData = MutableLiveData<MutableList<Survey>>()

    fun getAllTemplates() = runBlocking {
            surveyListLiveData.value = repository?.getAllSurveys(limit = 10, offset = 0)?.await()!!
    }


}