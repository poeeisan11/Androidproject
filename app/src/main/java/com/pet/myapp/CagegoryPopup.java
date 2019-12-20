package com.pet.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.zip.Inflater;

import es.dmoral.toasty.Toasty;

public class CagegoryPopup extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.categorypopup,container,false);
        final EditText edt_categoryname=view.findViewById(R.id.category_name);
        Button btn_save=view.findViewById(R.id.save_category);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edt_categoryname.getText().toString().equals("") && edt_categoryname.getText().toString()!=null)
                {
                    CategoryModel c=new CategoryModel(edt_categoryname.getText().toString());

                    FirebaseFirestore db=FirebaseFirestore.getInstance();
                    CollectionReference category_Ref=db.collection("categories");
                    category_Ref.add(c);
                    edt_categoryname.setText("");
                }
                else
                {
                    Toasty.error(getContext(),"Please fail category",Toasty.LENGTH_LONG).show();
                }
            }
        });
                return view;
    }
}
