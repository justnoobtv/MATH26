package com.example.thiti.math26;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class Easy_Hamster_Edit extends AppCompatActivity {

    ArrayList<String> myArrayList = new ArrayList<>();
    ListView myListView;
    Firebase myFirebase;
    EditText input1;
    TextView ProblemNumber;
    TextView message1;
    TextView message2;
    TextView message3;
    TextView message4;
    TextView message5;
    TextView message6;
    TextView message7;
    Button Next;
    int Answer1 = 8;
    int Answer2 = -1;
    int Answer3 = 13;
    int Answer4 = 19;
    int Answer5 = -20;
    int Answer6 = -5;
    int Answer7 = 18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy__hamster__edit);

        input1 = (EditText) findViewById(R.id.Answer1_1);
        ProblemNumber = (TextView) findViewById(R.id.ProNumber);
        message1 = (TextView) findViewById(R.id.message1);
        message2 = (TextView) findViewById(R.id.message2);
        message3 = (TextView) findViewById(R.id.message3);
        message4 = (TextView) findViewById(R.id.message4);
        message5 = (TextView) findViewById(R.id.message5);
        message6 = (TextView) findViewById(R.id.message6);
        message7 = (TextView) findViewById(R.id.message7);
        Next = (Button) findViewById(R.id.Next);

        Firebase.setAndroidContext(this);
        myFirebase = new Firebase("https://project-7787971703206926875.firebaseio.com/Q38_Easy");

        final ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myArrayList);
        myListView = (ListView)findViewById(R.id.ListView);
        myListView.setAdapter(myArrayAdapter);


        myFirebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String myChildValues = dataSnapshot.getValue(String.class);
                myArrayList.add(myChildValues);
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
    public void Confirm(View v) {
        int InputNumber = Integer.parseInt(input1.getText().toString());
        int InputNumber1 = Integer.parseInt(input1.getText().toString());
        int InputNumber2 = Integer.parseInt(input1.getText().toString());
        int InputNumber3 = Integer.parseInt(input1.getText().toString());
        int InputNumber4 = Integer.parseInt(input1.getText().toString());
        int InputNumber5 = Integer.parseInt(input1.getText().toString());
        int InputNumber6 = Integer.parseInt(input1.getText().toString());

        if (InputNumber == Answer1) {
            message1.setText("H");
        }
        if (Answer1 == InputNumber1){
            ProblemNumber.setText("2");
        }
        if (InputNumber1 == Answer2) {
            message2.setText("A");
        }
        if (Answer2 == InputNumber1){
            ProblemNumber.setText("3");
        }
        if (InputNumber2 == Answer3) {
            message3.setText("M");
        }
        if (Answer3 == InputNumber2){
            ProblemNumber.setText("4");
        }
        if (InputNumber3 == Answer4){
            message4.setText("S");
        }
        if (Answer4 == InputNumber3){
            ProblemNumber.setText("5");
        }
        if (InputNumber4 == Answer5) {
            message5.setText("T");
        }
        if (Answer5 == InputNumber4) {
            ProblemNumber.setText("6");
        }
        if (InputNumber5 == Answer6) {
            message6.setText("E");
        }
        if (Answer5 == InputNumber4) {
            ProblemNumber.setText("7");
        }
        if (InputNumber6 == Answer7) {
            message7.setText("R");
        }
        if (Answer7 == InputNumber6) {
            Next.setEnabled(true);
        }
    }
    public void Next(View v) {
        Next = (Button) findViewById(R.id.Next);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Easy_Hamster_Edit.this,Easy_Question27.class);
                startActivity(i);
            }
        });
    }
}
