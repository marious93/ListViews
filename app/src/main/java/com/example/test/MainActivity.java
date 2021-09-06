package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.test.ArrayAdapter.ListView_arrayAdapter;
import com.example.test.CustomListView.CustomListView;
import com.example.test.Product.ProductList;
import com.example.test.RecyclerView.RecyclerViewList;
import com.example.test.Test.ButtonActivity;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] menu = {"Usual button", "List View Adapter", "Custom Adapter", "List App", "Product List"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView menuList = (ListView) findViewById(R.id.menuList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, menu);
        menuList.setAdapter(adapter);

        menuList.setOnItemClickListener(this::onItemClick);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0){
            Intent intent = new Intent(this, ButtonActivity.class);
            startActivity(intent);
        }
        if (position == 1){
            Intent intent = new Intent(this, ListView_arrayAdapter.class);
            startActivity(intent);
        }
        if (position == 2){
            Intent intent = new Intent(this, CustomListView.class);
            startActivity(intent);
        }
        if (position == 3){
            Intent intent = new Intent(this, ListApp.class);
            startActivity(intent);
        }
        if (position == 4){
            Intent intent = new Intent(this, ProductList.class);
            startActivity(intent);
        }
        if (position == 5){
            Intent intent = new Intent(this, RecyclerViewList.class);
            startActivity(intent);
        }

    }
}