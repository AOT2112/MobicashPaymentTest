package com.compasplus.mobicashpaymenttest

import androidx.activity.ComponentActivity
import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Toast
import java.util.Locale

class SpeechInputManager(activity: ComponentActivity) {
    private val localActivity = activity

    fun getSpeechInput(context: Context) {
        // on below line we are checking if speech
        // recognizer intent is present or not.
        if (!SpeechRecognizer.isRecognitionAvailable(context)) {
            // if the intent is not present we are simply displaying a toast message.
            Toast.makeText(
                context,
                context.getString(R.string.speech_input_error),
                Toast.LENGTH_SHORT
            ).show()
        } else {
            // on below line we are calling a speech recognizer intent
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)

            // on the below line we are specifying language model as language web search
            intent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH
            )

            // on below line we are specifying extra language as default english language
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())

            // on below line we are specifying prompt as Speak something
            intent.putExtra(
                RecognizerIntent.EXTRA_PROMPT,
                context.getString(R.string.speech_prompt_display)
            )

            // at last we are calling start activity
            // for result to start our activity.
            localActivity.startActivityForResult(intent, 101)
        }
    }
}