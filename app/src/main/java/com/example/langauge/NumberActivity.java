package com.example.langauge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //------------ArrayList of Words

        ArrayList<Words> word = new ArrayList<Words>();
        word.add(new Words("one", "lutti",R.drawable.number_one));
        word.add(new Words("two", "otiiko",R.drawable.number_two));
        word.add(new Words("three", "tolookosu",R.drawable.number_three));
        word.add(new Words("four", "oyyisa",R.drawable.number_four));
        word.add(new Words("five", "massokka",R.drawable.number_five));
        word.add(new Words("six", "temmokka",R.drawable.number_six));
        word.add(new Words("seven", "kenekaku",R.drawable.number_seven));
        word.add(new Words("eight", "kawinta",R.drawable.number_eight));
        word.add(new Words("nine", "wo’e",R.drawable.number_nine));
        word.add(new Words("ten", "na’aacha",R.drawable.number_ten));

        WordAdapter adapter =new WordAdapter(this,word,R.color.color_number);
        ListView listView =(ListView) findViewById(R.id.list) ;
        listView.setAdapter(adapter);
    }
}
