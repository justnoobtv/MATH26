package com.example.thiti.math26;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class Normal_Question6 extends AppCompatActivity {

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
    Button Next;
    int Answer1 = -3;
    int Answer2 = 1;
    int Answer3 = 13;
    int Answer4 = -5;
    int Answer5 = -12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal__question6);
        input1 = (EditText) findViewById(R.id.Answer1_1);
        ProblemNumber = (TextView) findViewById(R.id.ProNumber);
        message1 = (TextView) findViewById(R.id.message1);
        message2 = (TextView) findViewById(R.id.message2);
        message3 = (TextView) findViewById(R.id.message3);
        message4 = (TextView) findViewById(R.id.message4);
        message5 = (TextView) findViewById(R.id.message5);
        Next = (Button) findViewById(R.id.Next);

        Firebase.setAndroidContext(this);
        myFirebase = new Firebase("https://project-7787971703206926875.firebaseio.com/Q12_Medium");

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

        if (InputNumber == Answer1) {
            message1.setText("C");
            input1.getText().clear();
            closeKeyboard();
        }
        if (Answer1 == InputNumber1){
            ProblemNumber.setText("ข้อ 2");
        }
        if (InputNumber1 == Answer2) {
            message2.setText("A");
            input1.getText().clear();
            closeKeyboard();
        }
        if (Answer2 == InputNumber1){
            ProblemNumber.setText("ข้อ 3");
        }
        if (InputNumber2 == Answer3) {
            message3.setText("M");
            input1.getText().clear();
            closeKeyboard();
        }
        if (Answer3 == InputNumber2){
            ProblemNumber.setText("ข้อ 4");
        }
        if (InputNumber3 == Answer4){
            message4.setText("E");
            input1.getText().clear();
            closeKeyboard();
        }
        if (Answer4 == InputNumber3){
            ProblemNumber.setText("ข้อ 5");
        }
        if (InputNumber4 == Answer5){
            message5.setText("L");
            input1.getText().clear();
            closeKeyboard();
        }
        if (Answer3 == InputNumber2) {
            dialogshow();
        }
        if (Answer5 == InputNumber4){
            Next.setEnabled(true);
        }
    }
    public void Next(View v) {
        Next = (Button) findViewById(R.id.Next);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Normal_Question6.this,Normal_Question7.class);
                startActivity(i);
            }
        });
    }
    public void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    public void dialogshow(){
        AlertDialog.Builder ImageDialog = new AlertDialog.Builder(Normal_Question6.this);
        ImageDialog.setTitle("Correct");
        ImageView showImage = new ImageView(Normal_Question6.this);
        showImage.setImageResource(R.drawable.camel);
        ImageDialog.setView(showImage);

        ImageDialog.setNegativeButton("ok", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });
        ImageDialog.show();
    }
}
