package com.example.mynotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText txtname,txtpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtname=(EditText)findViewById(R.id.editText1);
        txtpwd=(EditText)findViewById(R.id.editText2);

    }
    public void login(View v)
    {
        String valName= txtname.getText().toString();
        String valPwd= txtpwd.getText().toString();
        if((valName.equals("harman"))&&(valPwd.equals("harman"))) {

            Intent i = new Intent(login.this, MainActivity.class);
            startActivity(i);
        }

    }
}
