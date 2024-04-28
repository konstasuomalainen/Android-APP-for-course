package com.example.hellojava;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public Button button;

    public Button game;

    public TextView helloView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button = findViewById(R.id.button);
        game = findViewById(R.id.game);
        helloView = findViewById(R.id.helloView);



        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                handleOnClickEvents(v);
            }
        });

        game.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                handleOnClickEvents(v);
            }
        });


    }

    public void handleOnClickEvents(View view) {
        int currentId = view.getId();

        if (currentId == R.id.button) {
            Log.i("BUTTONS", "User tapped the Game Button");
            if (helloView.getVisibility() == View.VISIBLE) {
                helloView.setVisibility(View.INVISIBLE);
            } else
            {
                helloView.setVisibility(View.VISIBLE);
            }

        }

        if (currentId == R.id.game) {
            Log.i("BUTTONS", "User tapped the Button");
            Intent i = new Intent(this, gameApp.class);
            startActivity(i);
        }


    }




}