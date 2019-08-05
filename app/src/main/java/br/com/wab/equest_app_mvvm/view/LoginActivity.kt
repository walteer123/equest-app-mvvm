package br.com.wab.equest_app_mvvm.view

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.lifecycle.Observer
import br.com.wab.equest_app_mvvm.BaseActivity
import br.com.wab.equest_app_mvvm.R
import br.com.wab.equest_app_mvvm.databinding.ActivityLoginBinding
import br.com.wab.equest_app_mvvm.util.Preferences
import br.com.wab.equest_app_mvvm.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseUser
import java.lang.Exception

class LoginActivity : BaseActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@LoginActivity, R.layout.activity_login)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.vm = viewModel

        viewModel.firebaseUserLiveData.observe(this,
            Observer<FirebaseUser> {
                hideProgress()
                val intent = Intent(this@LoginActivity, DashBoardActivity::class.java)
                startActivity(intent)
            })

        viewModel.accessTokenLiveData.observe(this,
            Observer<String> { token ->
                hideProgress()
                Preferences.putString(this, "ACCESS_TOKEN", token)
            })

        binding.auth.setOnClickListener {
            try {
                showProgress()
                viewModel.loginWithCredentials(binding.login.text.toString(), binding.password.text.toString())
            }catch (exception:Exception){
                hideProgress()
                handleException(exception)
            }

        }
    }


}
