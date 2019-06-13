package com.example.langauge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //------------ArrayList of Words

        ArrayList<Words> word = new ArrayList<Words>();
        word.add(new Words("father", "әpә", R.drawable.family_father));
        word.add(new Words("mother", "әṭa", R.drawable.family_mother));
        word.add(new Words("son", "angsi", R.drawable.family_son));
        word.add(new Words("daughter", "tune", R.drawable.family_daughter));
        word.add(new Words("older brother", "taachi", R.drawable.family_older_brother));
        word.add(new Words("younger brother", "chalitti", R.drawable.family_younger_brother));
        word.add(new Words("older sister", "teṭe", R.drawable.family_older_sister));
        word.add(new Words("younger sister", "kolliti", R.drawable.family_younger_sister));
        word.add(new Words("grandmother ", "ama", R.drawable.family_grandmother));
        word.add(new Words("grandfather", "paapa", R.drawable.family_grandfather));

        WordAdapter adapter =new WordAdapter(this,word,R.color.color_family);
        ListView listView =(ListView) findViewById(R.id.list) ;
        listView.setAdapter(adapter);
    }
    }

