package com.example.booksmuslim;

import android.content.Context;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RetalPc on 02/21/2019.
 */

public class GetLesson {
    public List<Lesson> GetDate(Context cn,String chapno)
    {

        List<Lesson> data=new ArrayList<>();
        Database yehia=new Database();
        Connection hisham=yehia.ConnectDB();
        if(hisham==null)
            Toast.makeText(cn, "عفوا رجاء الاتصال با الانترنت", Toast.LENGTH_SHORT).show();
        else
        {
            ResultSet amr=yehia.RunSearch("select * from Lasson where Ch_namber ='"+chapno+"'");
            try {
                while (amr.next())
                {
                    Lesson israa=new Lesson();
                    israa.setCh_Number(amr.getString(1));
                    israa.setLe_Name(amr.getString(2));
                    israa.setLe_Details(amr.getString(3));
                    israa.setLe_Viduo(amr.getString(4));
                    israa.setLe_odiue(amr.getString(5));
                    israa.setCh_Number(amr.getString(6));
                    israa.setLe_Logo(amr.getString(7));
                    data.add(israa);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return data;
    }
}
