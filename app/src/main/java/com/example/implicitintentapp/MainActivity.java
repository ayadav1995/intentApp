package com.example.implicitintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.url);
        btn = findViewById(R.id.urlButton);
        btn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        String value = editText.getText().toString();
        Uri uri = Uri.parse(value);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        Intent intent1 = Intent.createChooser(intent,"Open with");
        startActivity(intent1);
    }
}