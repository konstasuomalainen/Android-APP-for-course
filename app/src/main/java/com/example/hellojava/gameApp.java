package com.example.hellojava;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class gameApp extends AppCompatActivity {

    private ImageButton imageButton1;

    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private TextView textView3;

    private TextView tulos;

    private FloatingActionButton floatingActionButton;
    public int randNumb1;

    public int randNumb2;
    public int randNumb3;
    public int randNumb4;

    public int image1;
    public int image2;
    public int image3;
    public int image4;

    public int largest;

    private int pisteet;

    private androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_app);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar = findViewById(R.id.gameToolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();


        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Random rand = new Random();

        int max=1000,min=0;
        randNumb1 = rand.nextInt((max - min + 1) + min);
        randNumb2 = rand.nextInt((max - min + 1) + min);
        randNumb3 = rand.nextInt((max - min + 1) + min);
        randNumb4 = rand.nextInt((max - min + 1) + min);
        image1 = randNumb1;
        image2 = randNumb2;
        image3 = randNumb3;
        image4 = randNumb4;

        largest = image1;

        if (image2 > largest)
        {
            largest = image2;
        }

        if (image3 > largest)
        {
            largest = image3;
        }
        if (image4 > largest)
        {
            largest = image4;
        }

        imageButton1 = findViewById(R.id.imageButton1);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        imageButton4 = findViewById(R.id.imageButton4);
        textView3 = findViewById(R.id.textView3);
        tulos = findViewById(R.id.tulos);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        imageButton1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {

                handleOnClickEvents(v);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                handleOnClickEvents(v);
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                handleOnClickEvents(v);
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                handleOnClickEvents(v);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                handleOnClickEvents(v);
            }
        });

    }




    public void handleOnClickEvents(View view) {

        int currentId = view.getId();




        Log.i("numb", "" + image1);
        Log.i("numb", "" +image2);
        Log.i("numb", "" +image3);
        Log.i("numb", ""+ image4);
        Log.i("numb", ""+ largest);

        if (currentId == R.id.imageButton1)
        {
            if(imageButton1.getVisibility() == View.VISIBLE)
            {
                imageButton1.setBackgroundColor(Color.WHITE);
                imageButton1.setVisibility(View.GONE);
               if (largest == image1)
               {
                   if(imageButton1.getVisibility() == View.GONE)
                   {
                       imageButton1.setImageResource(R.mipmap.unnamed1);
                       Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                       ImageView image = imageButton1;
                       image.startAnimation(animation);
                       imageButton1.setVisibility(View.VISIBLE);
                       tulos.setText("Onneksi olkoon");
                   }
               }

            }

        }
        if (currentId == R.id.imageButton2)
        {
            if(imageButton2.getVisibility() == View.VISIBLE)
            {
                imageButton2.setBackgroundColor(Color.WHITE);
                imageButton2.setVisibility(View.GONE);
                if (largest == image2)
                {
                    if(imageButton2.getVisibility() == View.GONE)
                    {
                        imageButton2.setImageResource(R.mipmap.unnamed1);
                        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                        ImageView image = imageButton2;
                        image.startAnimation(animation);
                        imageButton2.setVisibility(View.VISIBLE);
                        tulos.setText("Onneksi olkoon");
                    }
                }

            }

        }
        if (currentId == R.id.imageButton3)
        {
            if(imageButton3.getVisibility() == View.VISIBLE)
            {
                imageButton3.setBackgroundColor(Color.WHITE);
                imageButton3.setVisibility(View.GONE);
                if (largest == image3)
                {
                    if(imageButton3.getVisibility() == View.GONE)
                    {
                        imageButton3.setImageResource(R.mipmap.unnamed1);
                        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                        ImageView image = imageButton3;
                        image.startAnimation(animation);
                        imageButton3.setVisibility(View.VISIBLE);
                        tulos.setText("Onneksi olkoon");
                    }
                }

            }

        }
        if (currentId == R.id.imageButton4)
        {
            if(imageButton4.getVisibility() == View.VISIBLE)
            {
                imageButton4.setBackgroundColor(Color.WHITE);
                imageButton4.setVisibility(View.GONE);
                if (largest == image4)
                {
                    if(imageButton4.getVisibility() == View.GONE)
                    {
                        imageButton4.setImageResource(R.mipmap.unnamed1);
                        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                        ImageView image = imageButton4;
                        image.startAnimation(animation);
                        imageButton4.setVisibility(View.VISIBLE);
                        tulos.setText("Onneksi olkoon");
                    }
                }

            }

        }

        if (currentId == R.id.floatingActionButton)
        {
            Intent i = new Intent(this, gameApp.class);
            startActivity(i);
        }

        // Show back button in Toolbar

    }
}