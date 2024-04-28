package com.example.hellojava.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hellojava.R;
import com.example.hellojava.YTJActivity;
import com.example.hellojava.databinding.FragmentHomeBinding;
import com.example.hellojava.gameApp;
import com.google.android.material.textfield.TextInputEditText;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public Button button;

    public Button game;

    public Button companySearch;

    public TextInputEditText companyName;

    public TextView helloView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        button = root.findViewById(R.id.button);
        game = root.findViewById(R.id.game);
        helloView = root.findViewById(R.id.helloView);
        companyName = root.findViewById((R.id.companyName));
        companySearch = root.findViewById(R.id.companySearch);

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

        companySearch.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {

                handleOnSearchEvents(v);
            }
        });






        return root;
    }

    private void handleOnSearchEvents(View view) {
        int currentId = view.getId();


        String companyValue = String.valueOf(companyName.getText());
        Intent o = new Intent(getActivity(), YTJActivity.class);
        o.putExtra("Value1", companyValue);
        startActivity(o);
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
            Intent i = new Intent(getActivity(), gameApp.class);
            startActivity(i);
        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}