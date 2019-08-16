package kr.koohyongmo.voicerecognition

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BasePermissionActivity() {
    override fun getActivityLayout(): Int {
        return R.layout.activity_main
    }

    override fun setUpView() {
        setSupportActionBar(toolBar)

        speechToText.setOnClickListener { view ->
            Snackbar.make(view, "Speak now, App is listening", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            SttFactory
                .instance
                .with(SttFactory.TRANSLATORS.SPEECH_TO_TEXT,
                    object : ConversionCallback {
                        override fun onSuccess(result: String) {
                            sttOutput.text = result
                        }

                        override fun onCompletion() {
                        }

                        override fun onErrorOccurred(errorMessage: String) {
                            Log.d("mainError","Speech2Text Error: $errorMessage")
                        }

                    }).initialize("Speak Now !!", this@MainActivity)
        }
    }
}
