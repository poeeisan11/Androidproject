package com.pet.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addsubtractActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsubtract);
    }

    public void buclick1(View view) {
        EditText edtnum5=findViewById(R.id.edtnum3);//find with id to connect ui design and code
        String num1=edtnum5.getText().toString().trim();//incoming num to add num1
        int n3=Integer.parseInt(num1);
        EditText edtresult2=findViewById(R.id.edtresult1);
        EditText edtnum6=findViewById(R.id.edtnum4);
        String num2=edtnum6.getText().toString().trim();
        int n5=Integer.parseInt(num2);
        int result2=n3+n5;
        Toast.makeText(getApplicationContext(),result2,Toast.LENGTH_LONG).show();
    }
}
