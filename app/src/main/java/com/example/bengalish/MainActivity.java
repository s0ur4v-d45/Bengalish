package com.example.bengalish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textViewNum = (TextView) findViewById(R.id.numbers);

        textViewNum.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbersIntent);

            }
        });

        TextView family = (TextView) findViewById(R.id.family);

        // Set a click listener on that View
        family.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link FamilyActivity}
                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);

                // Start the new activity
                startActivity(familyIntent);
            }
        });


        TextView colors = (TextView) findViewById(R.id.colors);

        // Set a click listener on that View
        colors.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the colors category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ColorsActivity}
                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);

                // Start the new activity
                startActivity(colorsIntent);
            }
        });

        // Find the View that shows the phrases category
        TextView phrases = (TextView) findViewById(R.id.phrases);

        // Set a click listener on that View
        phrases.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link PhrasesActivity}
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);

                // Start the new activity
                startActivity(phrasesIntent);
            }
        });
    }
}
//    public void num(View view)
//    {
//        TextView numbers=(TextView)findViewById(R.id.numbers);
//        Intent numbersIntent=new Intent(this,NumbersActivity.class);
//        startActivity(numbersIntent);
//    }
//    public void fam(View view)
//    {
//        TextView family=(TextView)findViewById(R.id.family);
//        Intent familyIntent=new Intent(this,FamilyActivity.class);
//        startActivity(familyIntent);
//    }
//    public void col(View view)
//    {
//        TextView color=(TextView)findViewById(R.id.colors);
//        Intent colorIntent=new Intent(this,ColorsActivity.class);
//        startActivity(colorIntent);
//    }
//    public void phrases(View view)
//    {
//        TextView phrase=(TextView)findViewById(R.id.phrases);
//        Intent phraseIntent=new Intent(this,PhrasesActivity.class);
//        startActivity(phraseIntent);
//    }
//}