package com.google.ar.core.examples.java.ml.utils;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import com.google.ar.core.examples.java.ml.DetectedObjectResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Text_To_Speech_converter {
    String text;
    TextToSpeech tts ;

    public Text_To_Speech_converter( Context con,String text) {
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
