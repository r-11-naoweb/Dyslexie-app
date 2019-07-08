package com.imie.dyslexie_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ouvre l'activité contenant le texte de correction
        Button explicationButton = (Button) this.findViewById(R.id.button);
        explicationButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent correctionActivity = new Intent(MainActivity.this, CorrectionActivity.class);
                startActivity(correctionActivity);
            }
        });

        // Lance la récitation du google Home
        ImageButton googleHomeButton = (ImageButton) this.findViewById(R.id.imageButton);
        explicationButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        // Lance l'appel à l'Api de correction
        ImageButton correctionButton = (ImageButton) this.findViewById(R.id.imageButton3);
        explicationButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
    }
}
