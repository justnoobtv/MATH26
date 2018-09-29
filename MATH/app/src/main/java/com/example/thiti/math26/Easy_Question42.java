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

public class Easy_Question42 extends AppCompatActivity {

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
    TextView message8;
    TextView message9;
    TextView message10;
    TextView message11;
    TextView message12;
    Button Next;
    int Answer1 = -2;
    int Answer2 = -12;
    int Answer3 = 1;
    int Answer4 = 3;
    int Answer5 = -11;
    int Answer6 = 2;
    int Answer7 = 5;
    int Answer8 = -18;
    int Answer9 = -18;
    int Answer10 = -25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy__question42);

        input1 = (EditText) findViewById(R.id.Answer1_1);
        ProblemNumber = (TextView) findViewById(R.id.ProNumber);
        message1 = (TextView) findViewById(R.id.message1);
        message2 = (TextView) findViewById(R.id.message2);
        message3 = (TextView) findViewById(R.id.message3);
        message4 = (TextView) findViewById(R.id.message4);
        message5 = (TextView) findViewById(R.id.message5);
        message6 = (TextView) findViewById(R.id.message6);
        message7 = (TextView) findViewById(R.id.message7);
        message8 = (TextView) findViewById(R.id.message8);
        message9 = (TextView) findViewById(R.id.message9);
        message10 = (TextView) findViewById(R.id.message10);
        message11 = (TextView) findViewById(R.id.message11);
        message12 = (TextView) findViewById(R.id.message12);
        Next = (Button) findViewById(R.id.Next);

        Firebase.setAndroidContext(this);
        myFirebase = new Firebase("https://project-7787971703206926875.firebaseio.com/Q72_easy");

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
        int InputNumber7 = Integer.parseInt(input1.getText().toString());
        int InputNumber8 = Integer.parseInt(input1.getText().toString());
        int InputNumber9 = Integer.parseInt(input1.getText().toString());
        int InputNumber10 = Integer.parseInt(input1.getText().toString());

        if (InputNumber == Answer1) {
            message1.setText("B");
        }
        if (Answer1 == InputNumber1){
            ProblemNumber.setText("2");
        }
        if (InputNumber1 == Answer2) {
            message2.setText("L");
        }
        if (Answer2 == InputNumber2){
            ProblemNumber.setText("3");
        }
        if (InputNumber2 == Answer3) {
            message3.setText("A");
        }
        if (Answer3 == InputNumber2){
            ProblemNumber.setText("4");
        }
        if (InputNumber3 == Answer4){
            message4.setText("C");
        }
        if (Answer4 == InputNumber3){
            ProblemNumber.setText("5");
        }
        if (InputNumber4 == Answer5){
            message5.setText("K");
        }
        if (Answer5 == InputNumber4){
            ProblemNumber.setText("6");
        }
        if (InputNumber5 == Answer6){
            message6.setText("B");
        }
        if (Answer6 == InputNumber5){
            ProblemNumber.setText("7");
        }
        if (InputNumber6 == Answer7){
            message7.setText("E");
        }
        if (Answer7 == InputNumber6){
            ProblemNumber.setText("8");
        }
        if (InputNumber7 == Answer8){
            message8.setText("R");
        }
        if (Answer8 == InputNumber7){
            ProblemNumber.setText("9");
        }
        if (InputNumber8 == Answer9){
            message9.setText("R");
        }
        if (Answer9 == InputNumber8){
            ProblemNumber.setText("10");
        }
        if (InputNumber9 == Answer10){
            message10.setText("Y");
        }
        if (Answer10 == InputNumber9){
            Next.setEnabled(true);
        }
    }
    public void Next(View v) {
        Next = (Button) findViewById(R.id.Next);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Easy_Question42.this,Easy_Question42.class);
                startActivity(i);
            }
        });
    }
}
