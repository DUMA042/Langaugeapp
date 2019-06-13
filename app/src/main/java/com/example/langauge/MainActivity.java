package com.example.langauge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView number = (TextView) findViewById(R.id.numberid) ;
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numberIntent =new Intent(MainActivity.this,NumberActivity.class) ;
                startActivity(numberIntent);
            }
        });

        TextView  phase = (TextView) findViewById(R.id.phaseid) ;
        phase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phaseIntent =new Intent(MainActivity.this,PhaseActivity.class) ;
                startActivity(phaseIntent);
            }
        });

        TextView family = (TextView) findViewById(R.id.familyid) ;
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familyIntent =new Intent(MainActivity.this,FamilyActivity.class) ;
                startActivity(familyIntent);
            }
        });

        TextView color = (TextView) findViewById(R.id.colorid) ;
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorIntent =new Intent(MainActivity.this,ColorActivity.class) ;
                startActivity(colorIntent);
            }
        });
    }
}
