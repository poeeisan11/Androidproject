package com.pet.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MoviePopup  extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.moviepopup,container,false);
        final ArrayList<String> categories=new ArrayList<>();
        final Spinner spinner=view.findViewById(R.id.movie_category);
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        CollectionReference Ref=db.collection("categories");
        Ref.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for(DocumentSnapshot s:queryDocumentSnapshots){
                    CategoryModel c=s.toObject(CategoryModel.class);
                    categories.add(c.categoryName);
                                 }
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getContext() , android.R.layout.simple_dropdown_item_1line,categories);
                spinner.setAdapter(arrayAdapter);


            }
        });
        return view;
    }
}
