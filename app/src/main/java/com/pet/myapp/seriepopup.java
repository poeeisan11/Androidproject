package com.pet.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.protobuf.Enum;

public class seriepopup  extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.seriepopup,container,false);
        final Spinner spinner=view.findViewById(R.id.seriecategory);
        final ArrayList<String> names=new ArrayList<>();

        FirebaseFirestore db=FirebaseFirestore.getInstance();
        CollectionReference  reference=db.collection("categories");
        reference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                for (DocumentSnapshot  s:queryDocumentSnapshots)
                {
                    CategoryModel c=s.toObject(CategoryModel.class);
                    names.add(c.categoryName);
                }
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_dropdown_item_1line,names);
                spinner.setAdapter(arrayAdapter);

            }
        });


        Button save=view.findViewById(R.id.saveserie);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtname=view.findViewById(R.id.seriename);
                EditText edtimageview=view.findViewById(R.id.serieimage);
                EditText edtvideo=view.findViewById(R.id.serievideo);
                SerieModel serieModel=new SerieModel(
                        edtname.getText().toString().trim(),
                        edtimageview.getText().toString().trim(),
                        edtvideo.getText().toString().trim(),
                        names.get(spinner.getSelectedItemPosition())
                );
                FirebaseFirestore db=FirebaseFirestore.getInstance();
                CollectionReference serie_ref=db.collection("series");
                serie_ref.add(serieModel);

            }
        });
        return view;
    }
}
