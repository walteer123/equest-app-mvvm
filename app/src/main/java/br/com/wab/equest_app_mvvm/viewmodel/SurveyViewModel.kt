package br.com.wab.equest_app_mvvm.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import br.com.wab.equest_app_mvvm.model.Survey

class SurveyViewModel: BaseObservable() {

    val survey = ObservableField<Survey>()

}