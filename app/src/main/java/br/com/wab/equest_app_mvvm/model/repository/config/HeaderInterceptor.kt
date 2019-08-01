package br.com.wab.equest_app_mvvm.model.repository.config


import android.app.Application
import br.com.wab.equest_app_mvvm.util.Preferences
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response  = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("Access-Token", Preferences.getString(Application().applicationContext,"Access-Token",""))
                .build()
        )
    }
}