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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ShowToast {
    public static LinearLayout linearLayout;
    public static void showToast(Context context, String text) {

        Spannable spannable = new SpannableString(text);

        spannable.setSpan(new ForegroundColorSpan(Color.RED), 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        Toast toast = new  Toast(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.toast,linearLayout);

        TextView textView = view.findViewById(R.id.text);
        textView.setText(spannable);
        toast.setGravity(Gravity.CENTER, 0, 0);

        toast.setView(view);
        toast.show();
    }

}
