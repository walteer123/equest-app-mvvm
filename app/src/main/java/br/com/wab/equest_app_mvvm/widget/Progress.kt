package br.com.wab.equest_app_mvvm.widget

import android.app.ActionBar
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ProgressBar
import br.com.wab.equest_app_mvvm.R
import de.hdodenhof.circleimageview.CircleImageView
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar

class Progress(context: Context): Dialog(context){
    init {
        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL
        val params = ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT)
        val progressBar = ProgressBar(context)
        progressBar.indeterminateDrawable.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY)
        layout.addView(progressBar, params)
        addContentView(layout, params)
    }
}