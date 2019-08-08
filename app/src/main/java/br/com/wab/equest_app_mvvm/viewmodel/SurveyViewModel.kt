package br.com.wab.equest_app_mvvm.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import br.com.wab.equest_app_mvvm.model.Survey

class SurveyViewModel: ViewModel() {

    val survey = ObservableField<Survey>()

}