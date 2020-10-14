package com.example.stepappv2_01.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.stepappv2_01.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TextView stepsCountTextView;
    private ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        stepsCountTextView = (TextView) root.findViewById(R.id.stepsCount);
        stepsCountTextView.setText("100");

        progressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        progressBar.setMax(6000);
        progressBar.setProgress(1000);

        return root;
    }
}