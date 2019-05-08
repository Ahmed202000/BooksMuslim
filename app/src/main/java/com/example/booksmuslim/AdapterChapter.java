package com.example.booksmuslim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterChapter extends ArrayAdapter<DataChapter> {
    Context context;
    ArrayList < DataChapter > mCategoryList;

    public AdapterChapter(Context context , ArrayList <DataChapter> mCategoryList){
        super(context,R.layout.layoutchapter,mCategoryList);
        this.context = context;
        this.mCategoryList =mCategoryList;
    }

    public class Holder {
        TextView txtname;
        ImageView imgChap;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        DataChapter  data = getItem(position);

        Holder viewHolder;

        if (convertView == null){

            viewHolder = new Holder();


            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.layoutchapter,parent ,false);


            viewHolder.txtname= (TextView) convertView.findViewById(R.id.chapterName);
            viewHolder.imgChap  = (ImageView) convertView.findViewById(R.id.LoogoChapter);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (Holder) convertView.getTag();
        }

        viewHolder.txtname.setText(data.getChname());
        PicassoClinte.downloadImage(context,data.getChlogo(),viewHolder.imgChap);

      //  viewHolder.mImage

        return convertView;
    }




}
