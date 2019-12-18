package com.pet.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==(R.id.homemenu))
        {
         //   Toasty.success(getApplicationContext(), "Success!", Toast.LENGTH_SHORT, true).show();
            Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent);
            Toasty.success(getApplicationContext(),"click home",Toasty.LENGTH_LONG).show();
        }

        else
        {
            Toasty.success(getApplicationContext(),"click heip",Toasty.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menuresource,menu);
        SearchView searchView=(SearchView)menu.findItem(R.id.searchmenu).getActionView();
        SearchManager searchManager=(SearchManager)getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toasty.error(getApplicationContext(),query,Toasty.LENGTH_LONG).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toasty.error(getApplicationContext(),newText,Toasty.LENGTH_LONG).show();
                return true;
            }
        });
        return true;
    }
}
