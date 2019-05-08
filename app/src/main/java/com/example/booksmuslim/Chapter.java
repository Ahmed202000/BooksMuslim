package com.example.booksmuslim;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Chapter extends AppCompatActivity {

        GridView gv;

        public static String chatno;

        GitChapter g = new GitChapter();
        DataChapter datamodel;
        AdapterChapter adapterChapter;
        ArrayList<DataChapter> data;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chapter);

            gv= (GridView) findViewById(R.id.gvChapter);

            final SwipeRefreshLayout swp = (SwipeRefreshLayout) findViewById(R.id.SpwChapter);

            swp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    data = new ArrayList<>(g.GetDate(Chapter.this));
                    adapterChapter = new AdapterChapter(Chapter.this, data);
                    gv.setAdapter(adapterChapter);
                    swp.setRefreshing(false);
                }
            });

            data = new ArrayList<>(g.GetDate(Chapter.this));
            adapterChapter = new AdapterChapter(Chapter.this, data);
            gv.setAdapter(adapterChapter);

            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    datamodel = data.get(i);
                    chatno = datamodel.getChnumber();
                     startActivity(new Intent(Chapter.this, LessonActivity.class));

                }
            });

    }
}