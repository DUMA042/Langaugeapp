package com.example.langauge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //------------ArrayList of Words

        ArrayList<Words> word = new ArrayList<Words>();
        word.add(new Words("redd", "weṭeṭṭi", R.drawable.color_red));
        word.add(new Words("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow));
        word.add(new Words("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow));
        word.add(new Words("green", "chokokki", R.drawable.color_green));
        word.add(new Words("brown", "ṭakaakki", R.drawable.color_brown));
        word.add(new Words("gray", "ṭopoppi", R.drawable.color_gray));
        word.add(new Words("black", "kululli", R.drawable.color_black));
        word.add(new Words("white", "kelelli", R.drawable.color_white));

        WordAdapter adapter =new WordAdapter(this,word,R.color.color_color);
        ListView listView =(ListView) findViewById(R.id.list) ;
        listView.setAdapter(adapter);
    }
    }

