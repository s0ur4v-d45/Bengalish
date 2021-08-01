package com.example.bengalish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

private int colorResourceId;
    public WordAdapter(Context context, ArrayList<Word> pWords,int colorId) {
        super(context,0, pWords);
        this.colorResourceId=colorId;
    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word local_word = getItem(position);
        TextView bengaliTextView = (TextView) listItemView.findViewById(R.id.b_text_view);
        bengaliTextView.setText(local_word.getBengaliTranslation());
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(local_word.getEnglishTranslation());
        ImageView imageView=(ImageView) listItemView.findViewById(R.id.imageView);
        if(local_word.hasImage())
        {
            imageView.setImageResource(local_word.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else
        {
            imageView.setVisibility(View.GONE);
        }
      View textcontainer=listItemView.findViewById(R.id.text_container);
        int color=ContextCompat.getColor(getContext(),colorResourceId);
        textcontainer.setBackgroundColor(color);
        return listItemView;
//        return super.getView(position, convertView, parent);
    }


}
