package com.example.implicitintentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button btn;
    EditText num;
    Button callButton;
    String sNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.url);
        btn = findViewById(R.id.urlButton);
        btn.setOnClickListener(this);
        callButton = findViewById(R.id.callButton);
        num = findViewById(R.id.number);
        callButton.setOnClickListener(this::btnCall);

    }


    @Override
    public void onClick(View view) {
        String value = editText.getText().toString();
        Uri uri = Uri.parse(value);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        Intent intent1 = Intent.createChooser(intent,"Open with");
        startActivity(intent1);
    }

    public void btnCall(View view){
        Intent i = new Intent(Intent.ACTION_CALL);
        sNum = num.getText().toString();

        if(sNum.trim().isEmpty()){
            i.setData(Uri.parse("tel:11111111111"));

        }else{
            i.setData(Uri.parse("tel:" +sNum));
        }

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"Please grant the permission to call", Toast.LENGTH_SHORT).show();
            requestPermission();
        }else{
            startActivity(i);
        }
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},1);
    }

}