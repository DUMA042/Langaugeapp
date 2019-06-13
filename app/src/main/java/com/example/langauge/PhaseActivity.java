package com.example.langauge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //------------ArrayList of Words

        ArrayList<Words> word = new ArrayList<Words>();
        word.add(new Words("Where are you going?", "minto wuksus"));
        word.add(new Words("What is your name?", "tinnә oyaase'nә"));
        word.add(new Words("My name is...", "oyaaset..."));
        word.add(new Words("How are you feeling?", "michәksәs?"));
        word.add(new Words("I’m feeling good.", "kuchi achit"));
        word.add(new Words("Are you coming?", "әәnәs'aa?"));
        word.add(new Words("Yes, I’m coming.", "hәә’ әәnәm"));
        word.add(new Words("I’m coming.", "әәnәm"));
        word.add(new Words("Let’s go.", "yoowutis"));
        word.add(new Words("Come here.", "әnni'nem"));

        WordAdapter adapter =new WordAdapter(this,word,R.color.color_phrase);
        ListView listView =(ListView) findViewById(R.id.list) ;
        listView.setAdapter(adapter);
    }
    }

