package com.example.stepappv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int stepsCount = 0;
    private TextView showCountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCountTextView = (TextView) findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.start_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        stepsCount++;
        if(showCountTextView != null) {
            showCountTextView.setText(Integer.toString(stepsCount));
        }
    }
}