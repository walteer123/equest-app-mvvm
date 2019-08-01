package br.com.wab.equest_app_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.wab.equest_app_mvvm.model.repository.FirebaseAuthRepository
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(){

    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main+viewModelJob)

    val firebaseUserLiveData = MutableLiveData<FirebaseUser>()
    val accessTokenLiveData = MutableLiveData<String>()

    fun loginWithCredentials(login: String, password: String) =
        try {
            uiScope.launch {
                val response = FirebaseAuthRepository.loginWithCredentials(login, password)
                getAndSaveToken(true)
                firebaseUserLiveData.value = response.user
            }
        }catch (exception: Exception){
            throw (exception)
        }


    fun getAndSaveToken(forceRefresh: Boolean) =
        try {
            uiScope.launch {
                val response = FirebaseAuthRepository.getToken(forceRefresh)
                accessTokenLiveData.value = response.token
            }
        }catch (exception:Exception){
            throw (exception)
        }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}