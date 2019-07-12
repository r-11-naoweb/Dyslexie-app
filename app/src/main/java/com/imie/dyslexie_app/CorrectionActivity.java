package com.imie.dyslexie_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
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

        TextView explicationTextView = (TextView) findViewById(R.id.explanationText);
        explicationTextView.setMovementMethod(new ScrollingMovementMethod());
        String[] nameArray = {"Clivez", "Clique", "Cliquer", "Cliques" };

        String[]
                infoArray = {"", "", "", ""
        };


        CorrectionListAdapter whatever = new CorrectionListAdapter(this, nameArray, infoArray);
        listView = (ListView) findViewById(R.id.othersCorrectionsList);

        listView.setAdapter(whatever);

        Intent intent = getIntent();
        if (intent != null){
            String str = "";
            String correction = "";
            if (intent.hasExtra("indexError") && intent.hasExtra("indexCorrection")){
                str = intent.getStringExtra("indexError");
                TextView textView = (TextView) findViewById(R.id.errorWord);
                textView.setText(str);

                correction = intent.getStringExtra("indexCorrection");
                TextView textCorrectionView = (TextView) findViewById(R.id.correctionWord);
                textCorrectionView.setText(correction);
            }
        }

    }

    public void onClick(View v)
    {
        final int id = v.getId();
        switch (id){
            case R.id.vocalButton:
                // Lance la lecture par google assistant
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                TextView errorWordTw = findViewById(R.id.errorWord);
                String errorWord = errorWordTw.getText().toString();
                TextView correctionWordTw = findViewById(R.id.correctionWord);
                String correctionWord = correctionWordTw.getText().toString();
                TextView explanationTextTw = findViewById(R.id.explanationText);
                String explanationText = explanationTextTw.getText().toString();
                String sentence = explanationSentence(errorWord, correctionWord, explanationText);

                ClipData clip = ClipData.newPlainText("lecture_explication", sentence);
                clipboard.setPrimaryClip(clip);
                startActivity(new Intent(Intent.ACTION_VOICE_COMMAND).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                break;
        }
    }

    public String explanationSentence(String errorWord, String correctionWord, String explanation) {
        return String.format("Le mot %s doit s'écrire %s parce que %s", errorWord, correctionWord, explanation);
    }
}
