package com.google.ar.core.examples.java.ml.utils;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Varandeep
 */
public class TTS_Conversion {
    String text;
    TextToSpeech tts ;

    public TTS_Conversion(Context con, String text) {
        this.text = text;


        tts=new TextToSpeech(con, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i==TextToSpeech.SUCCESS){
                    int result= tts.setLanguage(Locale.ENGLISH);
                    if (result==TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED){
                        Toast.makeText(con,"The given object text could'nt be recognised !",Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(con,text,Toast.LENGTH_SHORT).show();
                    tts.speak(text,TextToSpeech.QUEUE_FLUSH,null);
                }
                else{
                    Toast.makeText(con,"Initiaiation pf audio output failed !",Toast.LENGTH_SHORT).show();

                }
            }

        });

    }
}

