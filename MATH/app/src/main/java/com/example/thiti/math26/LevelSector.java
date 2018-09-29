package com.example.thiti.math26;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.VideoView;
import java.util.ArrayList;
import java.util.Random;


public class LevelSector extends AppCompatActivity {

    private ImageButton easy;
    private ImageButton Normal;
    private ImageButton Hard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_sector);

        ImageButton myButton = (ImageButton) findViewById(R.id.imageButton7);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Class> activityList = new ArrayList<>();
                activityList.add(Easy_Question1.class);
                activityList.add(Easy_Question2.class);
                activityList.add(Easy_Question3.class);
                activityList.add(Easy_Question4.class);
                activityList.add(Easy_Question5.class);

                Random generator = new Random();
                int number = generator.nextInt(5) + 1;

                Class activity = null;

                switch(number) {
                    case 1:
                        activity = Easy_Question1.class;
                        activityList.remove(Easy_Question1.class);
                        break;
                    case 2:
                        activity = Easy_Question2.class;
                        activityList.remove(Easy_Question2.class);
                        break;
                    case 3:
                        activity = Easy_Question3.class;
                        activityList.remove(Easy_Question3.class);
                        break;
                    case 4:
                        activity = Easy_Question4.class;
                        activityList.remove(Easy_Question4.class);
                        break;
                    default:
                        activity = Easy_Question5.class;
                        activityList.remove(Easy_Question5.class);
                        break;
                }
                Intent intent = new Intent(getBaseContext(), activity);
                intent.putExtra("ACTIVITY_LIST", activityList);
                startActivity(intent);
            }
        });
        Normal = (ImageButton)findViewById(R.id.Normal);
        Normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LevelSector.this,Normal_Question1.class);
                startActivity(i);
            }
        });
        Hard = (ImageButton)findViewById(R.id.Hard);
        Hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LevelSector.this,Hard_Question1.class);
                startActivity(i);
            }
        });
    }
}
