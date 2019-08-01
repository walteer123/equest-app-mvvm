package br.com.wab.equest_app_mvvm

import androidx.appcompat.app.AppCompatActivity
import br.com.wab.equest_app_mvvm.widget.Progress
import org.jetbrains.anko.alert

open class BaseActivity: AppCompatActivity() {

    private var progress: Progress? = null

    fun handleException(exception: Throwable){
        alert("Erro: ${exception.message}", "Encontramos um erro:").show()
    }

    fun showProgress(){
        if(progress == null){
            progress = Progress(this)
        }
        progress?.show()
    }

    fun hideProgress(){
        if (progress != null && progress!!.isShowing) {
            progress!!.dismiss()
        }
    }

}