package br.com.wab.equest_app_mvvm.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.wab.equest_app_mvvm.BaseActivity
import br.com.wab.equest_app_mvvm.R
import br.com.wab.equest_app_mvvm.adapter.QuestionListAdapter
import br.com.wab.equest_app_mvvm.databinding.ActivitySurveyBinding
import br.com.wab.equest_app_mvvm.model.Question
import br.com.wab.equest_app_mvvm.model.QuestionType
import br.com.wab.equest_app_mvvm.util.add
import br.com.wab.equest_app_mvvm.viewmodel.SurveyViewModel

class SurveyActivity : BaseActivity() {

    lateinit var viewModel: SurveyViewModel
    lateinit var binding: ActivitySurveyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_survey)
        viewModel = ViewModelProviders.of(this@SurveyActivity).get(SurveyViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.questionListLiveData.observe(this@SurveyActivity,
            Observer<MutableList<Question>> {
                binding.questionRecyclerView.adapter?.notifyDataSetChanged() })

        viewModel.questionListLiveData.value = emptyList<Question>().toMutableList()

        binding.questionRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SurveyActivity)
            adapter = QuestionListAdapter(viewModel.questionListLiveData.value!!)
        }

        binding.fabAddQuestion.setOnClickListener {
            viewModel.questionListLiveData.add(
                Question(title = "Teste1", type = QuestionType.NUMBER, required = false)
            )

        }
    }
}
