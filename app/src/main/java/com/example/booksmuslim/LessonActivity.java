package com.example.booksmuslim;

import android.content.Intent;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

public class LessonActivity extends AppCompatActivity {

    private TextView loadLesson;
    private GetLesson g = new GetLesson();
    private Lesson datamodel;
    private AdapterLesson adapterLesson;
    private ArrayList<Lesson> data;

    GridView gvLesson;


    public static String Videorl;
    public static String TextView;
    public static String Oudeo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        loadLesson = findViewById(R.id.loadLesson);

        final SwipeRefreshLayout swp = (SwipeRefreshLayout) findViewById(R.id.swpLesson);
        swp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                data = new ArrayList<>(g.GetDate(LessonActivity.this, Chapter.chatno));
                adapterLesson = new AdapterLesson(LessonActivity.this, data);
                gvLesson.setAdapter(adapterLesson);
                swp.setRefreshing(false);
            }
        });

        gvLesson = (GridView) findViewById(R.id.gvLesson);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                data = new ArrayList<>(g.GetDate(LessonActivity.this, Chapter.chatno));

                ArrayList<Lesson> dd = new ArrayList<>(g.GetDate(LessonActivity.this, Chapter.chatno));
                adapterLesson = new AdapterLesson(LessonActivity.this, dd);
                gvLesson.setAdapter(adapterLesson);
                loadLesson.setVisibility(View.INVISIBLE);
            }
        }, 300);


        gvLesson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {

                datamodel = data.get(i);

                Videorl = datamodel.getLe_Viduo();
                TextView = datamodel.getLe_Details();
                Oudeo = datamodel.getLe_odiue();
                startActivity(new Intent(LessonActivity.this, LessonDetails.class));
            }
        });
    }
}
