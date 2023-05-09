package com.firstapp.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.SeekBar;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    ListView list;
    String lview[]
            = { "Theme (Gold)","Aga Naga(PS1)","Munthiri Padam (Kochirajavu)","Muthuvel Pandian (Jailer)","Announcement(Jailer)","Thee Thalapathy (Varisu)" };
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list =(ListView ) findViewById(R.id.lv);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        ArrayAdapter<String> arr = new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,lview);
        list.setAdapter(arr);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i == 0){
                    player = MediaPlayer.create(getApplicationContext(), R.raw.song);
                }

                if (i == 1){
                    player = MediaPlayer.create(getApplicationContext(), R.raw.song2);
                }
                if (i == 2){
                    player = MediaPlayer.create(getApplicationContext(), R.raw.soong3);
                }
                if (i == 3){
                    player = MediaPlayer.create(getApplicationContext(), R.raw.song4);
                }
                if (i == 4){
                    player = MediaPlayer.create(getApplicationContext(), R.raw.song5);
                }
                if (i == 5){
                    player = MediaPlayer.create(getApplicationContext(), R.raw.song6);
                }



            }
        });




    }
    public void play(View v) {
        if (player == null) {
            player = MediaPlayer.create(getApplicationContext(), R.raw.song);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();

                }
            });
        }
        player.start();
    }

    public void pause(View v) {
        if (player != null) {
            player.pause();
        }
    }

    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "STOPPED", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }

}