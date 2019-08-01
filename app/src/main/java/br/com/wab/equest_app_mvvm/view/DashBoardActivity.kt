package br.com.wab.equest_app_mvvm.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.wab.equest_app_mvvm.BaseActivity
import br.com.wab.equest_app_mvvm.R
import br.com.wab.equest_app_mvvm.adapter.SurveyListAdapter
import br.com.wab.equest_app_mvvm.databinding.ActivityDashBoardBinding
import br.com.wab.equest_app_mvvm.viewmodel.DashBoardViewModel

class DashBoardActivity : BaseActivity() {
    lateinit var viewModel: DashBoardViewModel
    lateinit var binding: ActivityDashBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DashBoardViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dash_board)
        binding.viewModel = viewModel

        viewModel.surveyListLiveData.observe(this, Observer {
            binding.templateRecyclerView.adapter?.notifyDataSetChanged()
        })

        viewModel.getAllTemplates()

        val callback = object: SurveyListAdapter.Callback{
            override fun onClickEdit(position: Int) {
                viewModel.surveyListLiveData.value?.get(position)
            }

            override fun onClickDelete(position: Int) {
                viewModel.surveyListLiveData.value?.get(position)
            }

            override fun onClickAnswers(position: Int) {
                viewModel.surveyListLiveData.value?.get(position)
            }
        }

        binding.templateRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@DashBoardActivity)
            this.adapter = SurveyListAdapter(viewModel.surveyListLiveData.value!!,callback)
        }

    }
}
