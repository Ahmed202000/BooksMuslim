package com.example.booksmuslim;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;

public class Register extends AppCompatActivity {


    Button btnCreate;
    EditText txtFullname, txtUsername, txtEmail, txtPassword;

    int xx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //تعريف المتغيرات
        txtFullname = (EditText) findViewById(R.id.txtfullname);
        txtUsername = (EditText) findViewById(R.id.txtusername);
        txtEmail = (EditText) findViewById(R.id.txtemail);
        txtPassword = (EditText) findViewById(R.id.txtpassword);
        btnCreate = (Button) findViewById(R.id.btnCraeat);


        //كود التحقق من الائميل
        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String ss = "[a-zA-Z0-9._-]+@[" + "a-z]+\\.+[a-z]+";
                if (txtEmail.getText().toString().matches(ss)) {
                    ;
                } else
                    txtEmail.setError("Invaild Email Address (user@domain)");

            }
        });

        //كود انشاء الحساب
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Database db = new Database();
                Connection conn = db.ConnectDB();

                if (conn == null)
                    Toast.makeText(Register.this, "Check internet access", Toast.LENGTH_SHORT).show();
                else {
                    if (txtFullname.getText().toString().isEmpty()) {
                        txtFullname.setError("Please Enter Full Name");
                        txtFullname.requestFocus();
                    } else {
                        if (txtPassword.getText().toString().isEmpty()) {
                            txtPassword.setError("Please Enter Password");
                            txtPassword.requestFocus();
                        } else {
                            if (txtUsername.getText().toString().isEmpty()) {
                                txtUsername.setError("Please Enter Username");
                                txtUsername.requestFocus();
                            } else {
                                if (txtEmail.getText().toString().isEmpty()) {
                                    txtEmail.setError("Please Enter Email");
                                    txtEmail.requestFocus();
                                } else {
                                    String msg = db.RUNDML("insert into Users values('" + txtUsername.getText() + "','" + txtEmail.getText() + "','" + txtPassword.getText() + "','" + txtFullname.getText() + "')");
                                    if (msg.equals("Ok")) {
                                        AlertDialog.Builder h = new AlertDialog.Builder(Register.this)
                                                .setTitle("Books Muslim")
                                                .setMessage("Your account has been created succeed :) ")
                                                .setIcon(R.drawable.logoo)
                                                .setPositiveButton("Thanks", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        startActivity(new Intent(Register.this, Login.class));
                                                    }
                                                });
                                        h.create();
                                        h.show();
                                    } else if (msg.contains("PRIMARY KEY")) {
                                        AlertDialog.Builder h = new AlertDialog.Builder(Register.this)
                                                .setTitle("Books Muslim")
                                                .setMessage("This user is present :) ")
                                                .setIcon(R.drawable.logoo)
                                                .setPositiveButton("Thanks", null);
                                        h.create();
                                        h.show();
                                    } else
                                        Toast.makeText(Register.this, "" + msg, Toast.LENGTH_SHORT).show();

                                }
                            }
                        }
                    }

                }

            }
        });
    }
}