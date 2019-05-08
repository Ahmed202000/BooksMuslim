package com.example.booksmuslim;

import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class LessonDetails extends AppCompatActivity {


    private  String url,text,aduio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_lesson_details);

        final MediaPlayer mediaPlayer=MediaPlayer.create( LessonDetails.this,R.raw.g);
        RadioButton ra=findViewById(R.id.rasund);


        ra.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v){
               mediaPlayer.start();
           }
       });


        url=LessonActivity.Videorl;
        Toast.makeText(this, ""+url, Toast.LENGTH_SHORT).show();
        text=LessonActivity.TextView;
        aduio=LessonActivity.Oudeo;

        TextView t=findViewById(R.id.txtDetails);
        t.setText(text);


        getWindow().setFormat(PixelFormat.UNKNOWN);


        VideoView Video=findViewById(R.id.Video);
        String ut=url;
        Uri uri=Uri.parse(ut);
        Video.setVideoURI(uri);
        Video.setMediaController(new MediaController(this));
        Video.requestFocus();
        Video.start();

       /* VideoView Video=findViewById(R.id.Video);
        String ut="android.resource://"+getPackageName()+R.raw.g;
        Uri uri=Uri.parse(ut);
        Video.setVideoURI(uri);
        Video.setMediaController(new MediaController(this));
        Video.requestFocus();
        Video.start();*/











    }
}
