package com.example.booksmuslim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterLesson extends ArrayAdapter<Lesson> {
    Context context;
    ArrayList <Lesson> mCategoryList;

    public AdapterLesson(Context context , ArrayList <Lesson> mCategoryList){
        super(context,R.layout.layoutlesson,mCategoryList);
        this.context = context;
        this.mCategoryList =mCategoryList;
    }

    public class Holder {
        TextView txtname;
        ImageView imgLesson;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        Lesson  data = getItem(position);

        Holder viewHolder;

        if (convertView == null){

            viewHolder = new Holder();


            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.layoutlesson,parent ,false);


            viewHolder.txtname =   convertView.findViewById(R.id.lessonName_L);
            viewHolder.imgLesson =  convertView.findViewById(R.id.imglesson_L);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (Holder) convertView.getTag();
        }

        viewHolder.txtname.setText(data.getLe_Name());
        PicassoClinte.downloadImage(context,data.getLe_Logo(),viewHolder.imgLesson);


      //  viewHolder.mImage

        return convertView;
    }




}
