package com.example.myapplication.Instruments;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.widget.Toast;

public class ShowTost {
    public static  void showTost(Context context, String text) {

        Spannable spannable = new SpannableString(text);
        spannable.setSpan(new ForegroundColorSpan(Color.RED), 0, text.length(),  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        Toast toast = Toast.makeText(context, spannable, Toast.LENGTH_SHORT);
        // сделать setview для тоаста

        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
