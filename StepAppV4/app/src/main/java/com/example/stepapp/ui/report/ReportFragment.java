package com.example.stepapp.ui.report;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.stepapp.R;
import com.example.stepapp.StepAppOpenHelper;
import com.example.stepapp.ui.home.HomeFragment;
import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

public class ReportFragment  extends Fragment {

    public int todaySteps = 0;

    MaterialButton getEntriesButton;
    MaterialButton todayButton;
    MaterialButton deleteButton;

    TextView todayStepsTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        if (container != null) {
            container.removeAllViews();
        }


        View root = inflater.inflate(R.layout.fragment_report, container, false);

        // GET ENTRIES button
        getEntriesButton = (MaterialButton) root.findViewById(R.id.button_get);
        getEntriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StepAppOpenHelper.loadRecords(getContext());
            }
        });

        // TODAY button
        todayButton = (MaterialButton) root.findViewById(R.id.button_today);
        todayStepsTextView = (TextView) root.findViewById(R.id.numCompletedSteps);
        todayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View nv) {
                Date cDate = new Date();
                String fDate = new SimpleDateFormat("yyyy-MM-dd").format(cDate);
                todaySteps = StepAppOpenHelper.loadSingleRecord(getContext(), fDate);
                todayStepsTextView.setText(String.valueOf(todaySteps));
            }
        });

        // DELETE button
        deleteButton = (MaterialButton) root.findViewById(R.id.button_delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StepAppOpenHelper.deleteRecords(getContext());
            }
        });

        ////


        return root;
    }










}
