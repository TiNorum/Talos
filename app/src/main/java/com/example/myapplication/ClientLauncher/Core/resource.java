package com.example.myapplication.ClientLauncher.Core;

import android.util.Xml;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class resource {
    String message, answer;

   public resource(String message) {
        this.message = message;
    }

    public String getMessage() throws UnsupportedEncodingException {


        return  new String(message.getBytes("UTF-8"),"ISO-8859-1");
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {

        this.answer = answer;
    }
}