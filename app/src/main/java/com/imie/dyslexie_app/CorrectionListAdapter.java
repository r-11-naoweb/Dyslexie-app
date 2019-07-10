package com.imie.dyslexie_app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CorrectionListAdapter extends ArrayAdapter {
    private final Activity context;
    private final String[] correctionsArray;
    private final String[] explanationsArray;

    public CorrectionListAdapter (Activity context, String[] correctionsArray, String[] explanationsArray){


        super(context,R.layout.correction_row , correctionsArray);
        this.context=context;
        this.correctionsArray = correctionsArray;
        this.explanationsArray = explanationsArray;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.correction_row, null,true);

        TextView anotherCorrection = (TextView) rowView.findViewById(R.id.anotherCorrection);
        TextView anotherExplanation = (TextView) rowView.findViewById(R.id.anotherExplanation);

        anotherCorrection.setText(correctionsArray[position]);
        anotherExplanation.setText(explanationsArray[position]);
        return rowView;

    };
}
