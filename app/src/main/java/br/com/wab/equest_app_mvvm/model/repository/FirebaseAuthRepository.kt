package br.com.wab.equest_app_mvvm.model.repository

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

object FirebaseAuthRepository {

    private val instance: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    suspend fun loginWithCredentials(login: String, password: String) =
        instance.signInWithEmailAndPassword(login, password).await()

    suspend fun getToken(forceRefresh: Boolean) =
        instance.getAccessToken(forceRefresh).await()

    suspend fun createUser(email: String, password: String) =
        instance.createUserWithEmailAndPassword(email, password).await()

    fun logout() = instance.signOut()
}