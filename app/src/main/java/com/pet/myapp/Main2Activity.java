package com.pet.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }



    public void buclick(View view) {
        EditText edtnum1 = findViewById(R.id.edtnum1);
        String n1 = edtnum1.getText().toString().trim();
        int num1 = Integer.parseInt(n1);
        EditText edtresult=findViewById(R.id.edtresult);
        EditText edtnum2 = findViewById(R.id.edtnum2);
        String n2 = edtnum2.getText().toString().trim();
        int num2 = Integer.parseInt(n2);

        int res = 0;
        Button btnselected=(Button)view;
        if(btnselected.getId()==R.id.addb)
        {
            res=num1+num2;
        }
        if(btnselected.getId()==R.id.subb)
        {
          res=num1-num2;
        }
        edtresult.setText(String.valueOf(res));
    }
}
