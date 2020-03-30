package com.technion.android.mylists;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private Button logout_button;
    private Button insert_button;
    private EditText list_item_text;
    private ListView list_view;
    private ArrayList<String> array_list;
    private MyAdapter adapter;
    private String item_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        logout_button = findViewById(R.id.logout_button);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignInActivity();
            }
        });

        list_item_text = findViewById(R.id.list_item_text);
        insert_button = findViewById(R.id.insert_button);
        list_view = findViewById(R.id.list);

        array_list = new ArrayList<String>();
        adapter = new MyAdapter(ListActivity.this, array_list);
        list_view.setAdapter(adapter);

        onInsert();
/*
        if(savedInstanceState != null) {
            savedInstanceState.getString("text");
            adapter.notifyDataSetChanged();
        }
*/
    }

    public void openSignInActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }

    public void onInsert(){
        insert_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                item_text = list_item_text.getText().toString();
                list_item_text.getText().clear();
                array_list.add(item_text);
                adapter.notifyDataSetChanged();
            }
        });
    }
/*
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("text", item_text);

    }*/
}
