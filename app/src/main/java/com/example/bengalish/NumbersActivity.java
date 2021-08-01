package com.example.bengalish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    public AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                //pause playback
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                //resume playback
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };


    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//        create an array of words
//        String[] words=new String[10];
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One", "Ek", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Two", "Dui", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Three", "Tin", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Four", "Char", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Five", "Paanch", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Six", "Chhoy", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Seven", "Shat", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Eight", "Aath", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Nine", "Noy", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Ten", "dosh", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });


//        LinearLayout linearLayoutview=(LinearLayout)findViewById(R.id.linear);
//        int index;
//        for(index=0;index<10;index++)
//        {
//            TextView textView=new TextView(this);
//            textView.setText(words.get(index));
//        }

//        words[0]="One";
//        words[1]="Two";
//        words[2]="Three";
//        words[3]="Four";
//        words[4]="Five";
//        words[5]="Six";
//        words[6]="Seven";
//        words[7]="Eight";
//        words[8]="Nine";
//        words[9]="Ten";
    }


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

        }
    }

}