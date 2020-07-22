package com.example.myapplication.ClientLauncher.Core;

public class resource {
    String message, answer;

   public resource(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}