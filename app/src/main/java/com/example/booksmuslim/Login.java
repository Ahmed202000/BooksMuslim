package com.example.booksmuslim;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends AppCompatActivity {

    Button btnregister,btnlogin;
    EditText txtUsername, txtPassword;
    CheckBox ckloginme;
    TextView txtforgeftpassword;

    public static String lang = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //قراءه من  SharedPreferences
        SharedPreferences SH = getSharedPreferences("Books Super", MODE_PRIVATE);
        String us = SH.getString("Username", null);
        String P = SH.getString("Password", null);

        if ((us != null) && (P != null)) {
            startActivity(new Intent(Login.this, Chapter.class));
        }


        txtUsername = (EditText) findViewById(R.id.txtusername);
        txtPassword = (EditText) findViewById(R.id.txtpassword);
        ckloginme = (CheckBox) findViewById(R.id.ckloginme);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnregister = (Button) findViewById(R.id.btnregister);

        //كود تسجيل الدخول
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtUsername.getText().toString().isEmpty()) {
                    txtUsername.setError("Enter username");
                    txtUsername.requestFocus();
                } else {
                    if (txtPassword.getText().toString().isEmpty()) {
                        txtPassword.setError("Enter password");
                        txtPassword.requestFocus();
                    } else {
                        Database db = new Database();
                        Connection conn = db.ConnectDB();

                        if (conn == null)
                            Toast.makeText(Login.this, "Check internet access", Toast.LENGTH_SHORT).show();
                        else {
                            ResultSet rs = db.RunSearch("select * from Users where UserName='" + txtUsername.getText() + "' and Password ='" + txtPassword.getText() + "'");
                            try {
                                if (rs.next()) {
                                    if (ckloginme.isChecked()) {
                                        getSharedPreferences("Books Super", MODE_PRIVATE)
                                                .edit()
                                                .putString("Username", txtUsername.getText().toString())
                                                .putString("Password", txtPassword.getText().toString())
                                                .commit();

                                    }
                                    startActivity(new Intent(Login.this, Chapter.class));
                                } else
                                    Toast.makeText(Login.this, "Invaild username or password", Toast.LENGTH_SHORT).show();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }


                        }
                    }
                }
            }
        });
        btnregister=(Button)findViewById(R.id.btnregister);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });

    }
}
