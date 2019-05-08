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

public class GitChapter {
    public List<DataChapter> GetDate(Context cn)
    {

        List<DataChapter> data=new ArrayList<>();
        Database yehia=new Database();
        Connection hisham=yehia.ConnectDB();
        if(hisham==null)
            Toast.makeText(cn, "عفوا رجاء الاتصال با الانترنت", Toast.LENGTH_SHORT).show();
        else
        {
            ResultSet amr=yehia.RunSearch("select * from Chapter");
            try {
                while (amr.next())
                {
                    DataChapter israa=new DataChapter();
                    israa.setChnumber(amr.getString(1));
                    israa.setChname(amr.getString(2));
                    israa.setChlogo(amr.getString(3));
                    data.add(israa);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return data;
    }
}
