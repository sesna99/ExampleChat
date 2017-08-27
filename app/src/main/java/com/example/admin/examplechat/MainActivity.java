package com.example.admin.examplechat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView chat_list;
    private EditText send_et;
    private Button send_btn;
    private ChatListAdapter adapter;
    private String userName;
    private String imei;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        chat_list = (ListView) findViewById(R.id.chat_list);
        send_et = (EditText) findViewById(R.id.send_et);
        send_btn = (Button) findViewById(R.id.send_btn);

        userName = Util.getInstance().getUserName();
        imei = Util.getInstance().getImei();

        initList();
    }

    public void initList(){
        adapter = new ChatListAdapter(MainActivity.this, new ArrayList<ChatDto>());
        chat_list.setAdapter(adapter);

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatDto chatDto = new ChatDto(userName, send_et.getText().toString(), imei);
                myRef.push().setValue(chatDto);
                send_et.setText("");
            }
        });

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ChatDto value = dataSnapshot.getValue(ChatDto.class);
                adapter.add(value);
                chat_list.setSelection(adapter.getCount() - 1);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
