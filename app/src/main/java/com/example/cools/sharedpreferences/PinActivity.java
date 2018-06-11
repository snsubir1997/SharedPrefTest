package com.example.cools.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PinActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1;
    String p;
    Button b1;
    Intent j;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        e1 = findViewById(R.id.pin);
        b1 = findViewById(R.id.submitBtn);
        b1.setOnClickListener(this);

        j = getIntent();
        p = j.getStringExtra("p");
        Toast.makeText(getApplicationContext(),p,Toast.LENGTH_SHORT);
    }

    @Override
    public void onClick(View v) {
        String pin = e1.getText().toString();

        if(p == pin)
        {
            Toast.makeText(getApplicationContext(),"yes",Toast.LENGTH_SHORT);
            Intent i = new Intent(PinActivity.this,LoginActivity.class);
            startActivity(i);
        }
    }
}
