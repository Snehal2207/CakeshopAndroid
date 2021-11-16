package com.example.cakeshopip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.Locale;

public class ProductActivity extends AppCompatActivity {

    RecyclerView rView;
    private Query query;
    MyAdapter myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        rView=(RecyclerView)findViewById(R.id.rView);
        rView.setLayoutManager(new LinearLayoutManager(this));

        query = FirebaseDatabase.getInstance().getReference().child("cakeDB");
        FirebaseRecyclerOptions<Cake> options = new FirebaseRecyclerOptions.Builder<Cake>()
                .setQuery(query, Cake.class).build();
        myAdapter = new MyAdapter(options);
        rView.setAdapter(myAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myAdapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item=menu.findItem(R.id.search);
        SearchView searchView=(SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                txtSearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                txtSearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


    private void txtSearch(String str){

        query = FirebaseDatabase.getInstance().getReference()
                .child("cakeDB").orderByChild("name").startAt(str).endAt(str+"~");
        FirebaseRecyclerOptions<Cake> options = new FirebaseRecyclerOptions.Builder<Cake>()
                .setQuery(query, Cake.class).build();

        myAdapter=new MyAdapter(options);
        myAdapter.startListening();
        rView.setAdapter(myAdapter);
    }
}