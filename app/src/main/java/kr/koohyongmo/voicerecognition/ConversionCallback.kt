package kr.koohyongmo.voicerecognition

interface ConversionCallback {

    fun onSuccess(result: String)

    fun onCompletion()

    fun onErrorOccurred(errorMessage: String)

} 