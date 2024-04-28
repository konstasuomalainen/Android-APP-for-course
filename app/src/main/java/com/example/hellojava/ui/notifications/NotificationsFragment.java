package com.example.hellojava.ui.notifications;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hellojava.R;
import com.example.hellojava.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    NumberPicker numberPicker;

    Button startBtn;

    Button pauseBtn;

    Button stopBtn;

    TextView timerTxt;

    private long remainingTime = 0;

    private CountDownTimer countDownTimer;

    private boolean isCountdownRunning = false;

    private boolean isPaused = false;

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        timerTxt = root.findViewById(R.id.timerTxt);

        numberPicker = root.findViewById(R.id.numberPicker);

        startBtn = root.findViewById(R.id.startBtn);

        pauseBtn = root.findViewById(R.id.pauseBtn);

        stopBtn = root.findViewById(R.id.stopBtn);




        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                handleOnClickEvents(v);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                handleOnClickEvents(v);
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                handleOnClickEvents(v);
            }
        });
        return root;
    }

    private void handleOnClickEvents(View view) {
        int currentId = view.getId();

        if (currentId == R.id.startBtn && !isCountdownRunning) {
            startCountdown();
        }
        else if (currentId == R.id.pauseBtn && isCountdownRunning ) {
            pauseCountdown();

        }
        else if (currentId == R.id.stopBtn && isCountdownRunning) {
            stopCountdown();

        }
    }

    public void startCountdown() {
        isCountdownRunning = true;

        int value;
        if (remainingTime > 0) {

            value = (int) remainingTime;
        } else {

            value = 1000 * numberPicker.getValue();
        }

        countDownTimer = new CountDownTimer(value, 1000) {
            public void onTick(long millisUntilFinished) {
                timerTxt.setText("seconds remaining: " + millisUntilFinished / 1000);
                remainingTime = millisUntilFinished;
            }

            public void onFinish() {
                timerTxt.setText("done!");
                countDownTimer = null;
                isCountdownRunning = false;
                remainingTime = 0;


            }
        }.start();
    }

    public void pauseCountdown() {
        countDownTimer.cancel();
        isCountdownRunning = false;


    }

    private void stopCountdown() {
        countDownTimer.cancel();
        countDownTimer = null;
        timerTxt.setText("Countdown stopped");
        isCountdownRunning = false;
        remainingTime = 0;


    }

    @Override
    public void onStart() {
        super.onStart();
        setNumbers();
    }

    public void setNumbers()
    {
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(60);
        int numOfValues = 61;
        String[] displayedValues = new String[numOfValues];
        for (int i = 0; i < numOfValues; i++) {
            displayedValues[i] = String.valueOf(i % 61) + "s";
        }
        numberPicker.setDisplayedValues(displayedValues);
        Log.d(TAG, "setNumbers: " + displayedValues.toString());
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}