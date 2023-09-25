package com.google.ar.core.examples.java.ml.utils;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;

public class Text_To_Speech_converter {
    String text;
    TextToSpeech tts = null;
    TextToSpeech finalTts = tts;

    public Text_To_Speech_converter( Context con) {
        this.text = text;


        tts=new TextToSpeech(con, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i==TextToSpeech.SUCCESS){
                    int result= finalTts.setLanguage(Locale.ENGLISH);
                    if (result==TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED){
                        Toast.makeText(con,"The given object text could'nt be recognised !",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(con,"Initiaiation pf audio output failed !",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void speak(String text){
        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
}
