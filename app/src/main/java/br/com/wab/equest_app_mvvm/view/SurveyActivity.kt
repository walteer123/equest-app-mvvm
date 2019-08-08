package br.com.wab.equest_app_mvvm.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import br.com.wab.equest_app_mvvm.BaseActivity
import br.com.wab.equest_app_mvvm.R
import br.com.wab.equest_app_mvvm.databinding.ActivitySurveyBinding
import br.com.wab.equest_app_mvvm.viewmodel.SurveyViewModel

class SurveyActivity : BaseActivity() {

    lateinit var viewModel: SurveyViewModel
    lateinit var binding: ActivitySurveyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_survey)
        viewModel = ViewModelProviders.of(this@SurveyActivity).get(SurveyViewModel::class.java)
        binding.viewmodel = viewModel


    }
}
