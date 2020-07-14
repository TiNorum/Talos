package com.example.myapplication.Instruments;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ShowToast {
    public static void showToast(Context context, String text, ViewGroup viewGroup) {

        Spannable spannable = new SpannableString(text);
        spannable.setSpan(new ForegroundColorSpan(Color.RED), 0, text.length(),  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        Toast toast = Toast.makeText(context, spannable, Toast.LENGTH_SHORT);
        TextView textView;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.toast, viewGroup);
        toast.setView(view);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showToast(Context context, String text) {

        Spannable spannable = new SpannableString(text);
        spannable.setSpan(new ForegroundColorSpan(Color.RED), 0, text.length(),  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        Toast toast = Toast.makeText(context, spannable, Toast.LENGTH_SHORT);

        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
