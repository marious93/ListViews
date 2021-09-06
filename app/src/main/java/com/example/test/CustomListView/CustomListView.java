package com.example.test.CustomListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.test.R;

import java.util.ArrayList;

public class CustomListView extends AppCompatActivity {
      //  setContentView(R.layout.activity_custom_list_view);
            ArrayList<State> states = new ArrayList();
            ListView countriesList;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.custom_listview);
                // начальная инициализация списка
                setInitialData();
                // получаем элемент ListView
                countriesList = (ListView) findViewById(R.id.countriesList);
                // создаем адаптер
                StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_item, states);
                // устанавливаем адаптер
                countriesList.setAdapter(stateAdapter);
                // слушатель выбора в списке
                AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                        // получаем выбранный пункт
                        State selectedState = (State)parent.getItemAtPosition(position);
                        Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(),
                                Toast.LENGTH_SHORT).show();
                    }
                };
                countriesList.setOnItemClickListener(itemListener);
            }
            private void setInitialData(){

                states.add(new State ("Бразилия", "Бразилиа", R.drawable.brazilia));
                states.add(new State ("Аргентина", "Буэнос-Айрес", R.drawable.argentina));
                states.add(new State ("Колумбия", "Богота", R.drawable.columbia));
                states.add(new State ("Уругвай", "Монтевидео", R.drawable.uruguai));
                states.add(new State ("Чили", "Сантьяго", R.drawable.chile));
            }
        }