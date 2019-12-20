package com.pet.myapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;


/**
 * A simple {@link Fragment} subclass.
 */
public class category1Fragment extends Fragment {


    public category1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_category1, container, false);
        FloatingActionButton fb=view.findViewById(R.id.floatingbutton);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getFragmentManager();
                CagegoryPopup cat=new CagegoryPopup();
                cat.show(fragmentManager,"Show Fragment");
            }
        });
        ListView listView=view.findViewById(R.id.category_list);
        ArrayList<CategoryModel> categoryModels=new ArrayList<CategoryModel>();
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        CollectionReference categories=db.collection("categories");
        categories.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for(DocumentSnapshot s:queryDocumentSnapshots)
                {

                }
            }
        })
        return view;
    }

}
