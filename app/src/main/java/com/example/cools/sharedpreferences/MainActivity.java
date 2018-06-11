package com.example.cools.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText e1,e2,e3;
    Button b1;
    SharedPreferences shp;
    String UKEY = "", UPWD = "", UPIN = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shp = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);

        if (shp.contains(UKEY) && shp.contains(UPIN) && shp.contains(UPWD))
        {
            Intent i =new Intent(MainActivity.this,PinActivity.class);
            i.putExtra("p",UPIN);
            startActivity(i);
            finish();
        }
        else {

            e1 = findViewById(R.id.usernameField);
            e2 = findViewById(R.id.pwdField);
            e3 = findViewById(R.id.pinField);
            b1 = findViewById(R.id.signUpSubmit);

            b1.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
            String username = e1.getText().toString();
            String password = e2.getText().toString();
            String pin = e3.getText().toString();

            SharedPreferences.Editor edt = shp.edit();
            edt.putString(UKEY, username);
            edt.putString(UPWD, password);

            edt.putString(UPIN, pin);
            edt.commit();

        Intent i =new Intent(MainActivity.this,PinActivity.class);
        i.putExtra("pin",UPIN);
        startActivity(i);
        finish();
    }
}
