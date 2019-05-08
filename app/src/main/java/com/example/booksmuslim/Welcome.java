package com.example.booksmuslim;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    TextView loadWelcom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        loadWelcom=findViewById(R.id.loadWelcom);
        loadWelcom.setVisibility(View.INVISIBLE);


        // 3000
        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent a=new Intent(Welcome.this,Login.class);
                startActivity(a);
                finish();
            }
        },2000);

        //كود الافيقت
        ImageView image = (ImageView)findViewById(R.id.image);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim);
        image.startAnimation(animation);


    }
}