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
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correction);

        TextView explicationTextView = (TextView) findViewById(R.id.explicationText);
        explicationTextView.setMovementMethod(new ScrollingMovementMethod());
        String[] nameArray = {"Correction 1","Correction 2","Correction 3","Correction 4","Correction 5","Correction 6" };

        String[]
                infoArray = {"Explanation 1",
                "Explanation 2",
                "Explanation 3",
                "Explanation 4",
                "Explanation 5",
                "Explanation 6"
        };


        CorrectionListAdapter whatever = new CorrectionListAdapter(this, nameArray, infoArray);
        listView = (ListView) findViewById(R.id.othersCorrectionsList);

        listView.setAdapter(whatever);

        //ListView listView = (ListView) findViewById(R.id.correctionText);
        //listView.setAdapter();

    }
}
