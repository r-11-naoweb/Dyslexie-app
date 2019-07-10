package com.imie.dyslexie_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ouvre l'activité contenant le texte de correction
        Button explicationButton = (Button) this.findViewById(R.id.explanationButton);
        // Lance la récitation du google Home
        ImageButton googleHomeButton = (ImageButton) this.findViewById(R.id.vocalButton);
        // Lance l'appel à l'Api de correction
        ImageButton correctionButton = (ImageButton) this.findViewById(R.id.correctionButton);

    }

    public void onClick(View v)
    {
        final int id = v.getId();
        switch (id){
            case R.id.explanationButton:
                Intent correctionActivity = new Intent(MainActivity.this, CorrectionActivity.class);
                startActivity(correctionActivity);
                break;
            case R.id.vocalButton:
                // Lance la récitation du google Home
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("répète", "how are you today");
                clipboard.setPrimaryClip(clip);
                startActivity(new Intent(Intent.ACTION_VOICE_COMMAND).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            case R.id.correctionButton:
                // Lance l'appel à l'Api de correction
        }

    }
}
