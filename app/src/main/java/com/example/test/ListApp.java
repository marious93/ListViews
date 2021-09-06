package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.test.R;

import java.util.ArrayList;
import java.util.Collections;

public class ListApp extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_app);

        ArrayList<String> users = new ArrayList<String>();
        ArrayList<String> selectedUsers = new ArrayList<String>();
        ArrayAdapter<String> adapter;
        ListView usersList;
        EditText userName = (EditText) findViewById(R.id.userName);
        // добавляем начальные элементы
        Collections.addAll(users, "Tom", "Bob", "Sam", "Alice");
        // получаем элемент ListView
        usersList = (ListView) findViewById(R.id.usersList);
        Button buttonAdd = (Button) findViewById(R.id.add);
        Button buttonRemove = (Button) findViewById(R.id.remove);
        // создаем адаптер
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, users);
        // устанавливаем для списка адаптер
        usersList.setAdapter(adapter);

        // обработка установки и снятия отметки в списке
        usersList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                // получаем нажатый элемент
                String user = adapter.getItem(position);
                if(usersList.isItemChecked(position))
                    selectedUsers.add(user);
                else
                    selectedUsers.remove(user);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userName.getText().toString();
                if(!user.isEmpty()){
                    adapter.add(user);
                    userName.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // получаем и удаляем выделенные элементы
                for(int i=0; i< selectedUsers.size();i++){
                    adapter.remove(selectedUsers.get(i));
                }
                // снимаем все ранее установленные отметки
                usersList.clearChoices();
                // очищаем массив выбраных объектов
                selectedUsers.clear();

                adapter.notifyDataSetChanged();
            }
    });
    }
}