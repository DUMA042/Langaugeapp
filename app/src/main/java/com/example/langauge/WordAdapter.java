package com.example.langauge;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Words> {
    //* Resource ID for the background color
    private  int ColorResourceId ;
    public WordAdapter(Context context, ArrayList<Words> word,int ColorResourceId ) {
        super(context,0,word);
        this.ColorResourceId=ColorResourceId;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView ;
        if(listItemView==null) {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false) ;
        }
        Words currentWord =getItem(position) ;
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwordsid);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        miwokTextView.setText(currentWord.getMiworkTrans());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.engwordsid);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        defaultTextView.setText(currentWord.getEnglishTrans());

        ImageView iconimage=(ImageView) listItemView.findViewById(R.id.imageid);
        if(currentWord.check_for_image()){
            iconimage.setImageResource(currentWord.getImageid());
            iconimage.setVisibility(View.VISIBLE);
        }
        else{
            iconimage.setVisibility(View.GONE);
        }
View textcon =listItemView.findViewById(R.id.text_layoutid);
        int color= ContextCompat.getColor(getContext(),ColorResourceId);
        textcon.setBackgroundColor(color);
        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;

    }
}
