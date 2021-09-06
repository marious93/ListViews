package com.example.test.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.test.CustomListView.State;
import com.example.test.R;

import java.util.ArrayList;

public class RecyclerViewList extends AppCompatActivity {
    ArrayList<State> states = new ArrayList<State>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerAdapter.OnStateClickListener stateClickListener = new RecyclerAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(State state, int position) {

                Toast.makeText(getApplicationContext(), "Был выбран пункт " + state.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };

            // начальная инициализация списка
            setInitialData();
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
            // создаем адаптер
            RecyclerAdapter adapter = new RecyclerAdapter(this, states, stateClickListener);
            // устанавливаем для списка адаптер
            recyclerView.setAdapter(adapter);

        }
        private void setInitialData(){

            states.add(new State ("Бразилия", "Бразилиа", R.drawable.brazilia));
            states.add(new State ("Аргентина", "Буэнос-Айрес", R.drawable.argentina));
            states.add(new State ("Колумбия", "Богота", R.drawable.columbia));
            states.add(new State ("Уругвай", "Монтевидео", R.drawable.uruguai));
            states.add(new State ("Чили", "Сантьяго", R.drawable.chile));
        }

    }