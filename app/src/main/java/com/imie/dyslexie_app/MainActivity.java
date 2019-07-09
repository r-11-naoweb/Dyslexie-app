package com.imie.dyslexie_app;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

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
        Button explicationButton = (Button) this.findViewById(R.id.explication);
        // Lance la récitation du google Home
        ImageButton googleHomeButton = (ImageButton) this.findViewById(R.id.imageButton);
        // Lance l'appel à l'Api de correction
        ImageButton correctionButton = (ImageButton) this.findViewById(R.id.imageButton3);

    }

    public void onClick(View v)
    {
        final int id = v.getId();
        switch (id){
            case R.id.explication:
                Intent correctionActivity = new Intent(MainActivity.this, CorrectionActivity.class);
                startActivity(correctionActivity);
                break;
        }

    }
}
