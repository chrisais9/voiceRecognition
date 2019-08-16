package kr.koohyongmo.voicerecognition

import android.app.Activity

class SttFactory private constructor() {

    enum class TRANSLATORS {
        SPEECH_TO_TEXT
    }

    interface IConverter {
        fun initialize(message: String, appContext: Activity): IConverter

        fun getErrorText(errorCode: Int): String
    }


    fun with(TRANSLATORS: TRANSLATORS, conversionCallback: ConversionCallback): IConverter {
        return when (TRANSLATORS) {
            SttFactory.TRANSLATORS.SPEECH_TO_TEXT ->

                //Get speech to text translator
                SpeechToTextConverter(conversionCallback)
        }
    }

    companion object {
        val instance = SttFactory()
    }
}