package com.imie.dyslexie_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CorrectionActivity extends AppCompatActivity {

    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correction);

        TextView explicationTextView = (TextView) findViewById(R.id.explicationText);
        explicationTextView.setMovementMethod(new ScrollingMovementMethod());



        //ListView listView = (ListView) findViewById(R.id.correctionText);
        //listView.setAdapter();

    }
}
