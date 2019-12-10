package com.pet.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void buAdd(View view) {
        try {
            EditText edtnum1 = findViewById(R.id.edtnum1);
            String n1 = edtnum1.getText().toString();
            int num1 = Integer.parseInt(n1);

            EditText edtnum2 = findViewById(R.id.edtnum2);
            String n2 = edtnum2.getText().toString();
            int num2 = Integer.parseInt(n2);
            int res = num1 + num2;
            EditText edtresult=findViewById(R.id.edtresult);
            edtresult.setText(String.valueOf(res));
            edtnum1.setText("");
            edtnum2.setText("");


            Toast.makeText(getApplicationContext(), String.valueOf(res), Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Input error", Toast.LENGTH_LONG).show();
        }
    }

    public void buSubtract(View view) {
        try {
            EditText edtnum1 = findViewById(R.id.edtnum1);
            String n1 = edtnum1.getText().toString();
            int num1 = Integer.parseInt(n1);

            EditText edtnum2 = findViewById(R.id.edtnum2);
            String n2 = edtnum2.getText().toString();
            int num2 = Integer.parseInt(n2);
            int res = num1 - num2;
            EditText edtresult=findViewById(R.id.edtresult);
            edtresult.setText(String.valueOf(res));
            edtnum1.setText("");
            edtnum2.setText("");


            Toast.makeText(getApplicationContext(), String.valueOf(res), Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Input error", Toast.LENGTH_LONG).show();
        }
    }
}
