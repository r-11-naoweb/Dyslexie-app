package com.imie.dyslexie_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
        final TextView errorWord = (TextView) this.findViewById(R.id.errorWord);
        final TextView correctionWord = (TextView) this.findViewById(R.id.correctionWord);

        final EditText editText = (EditText) this.findViewById((R.id.inputText)) ;
        String texte = editText.getText().toString();

        final SpannableString spanString = new SpannableString(texte);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {

                /*Intent correctionActivity = new Intent(MainActivity.this, CorrectionActivity.class);
                startActivity(correctionActivity);*/
                String erreur = "aze";
                errorWord.setText(erreur);

                String correction = "azerty";
                correctionWord.setText(correction);
            }
        };

        spanString.setSpan(clickableSpan, 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        editText.setText(spanString);
        editText.setMovementMethod(LinkMovementMethod.getInstance());

    }

    public void onClick(View v)
    {
        final int id = v.getId();
        switch (id){
            case R.id.explanationButton:
                Intent correctionActivity = new Intent(MainActivity.this, CorrectionActivity.class);
                correctionActivity.putExtra("indexError", "aze");
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
                EditText texte = (EditText) this.findViewById(R.id.inputText);
                String texteApi = texte.getText().toString();
                //LanguageToolApi infos = new LanguageToolApi(texteApi);
                //System.out.println(infos.getListError().get(0));
                break;
        }

    }
}
