package com.example.dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    // for the date picker
    private TextView dateDisplay, timeDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // for the date picker
        dateDisplay = findViewById(R.id.txtdata);
        findViewById(R.id.btnDatePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDataPickerDialog();
            }
        });
    // this is for the time picker
        timeDisplay =findViewById(R.id.txtTime);
        Button btnTime = findViewById(R.id.btnTimePicker);
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
            }
        });

    }  // end of on Create

    private void showDataPickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

        );
        datePickerDialog.show();
    }

    public void confirmDelete(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete Dialog");
        builder.setMessage("Are you sure you wanto to delete?");


        builder
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // do anything you want here
                        Toast.makeText(MainActivity.this, "OK Pressed", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // do anything you want here
                        Toast.makeText(MainActivity.this, "Cancelled Pressed", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.create().show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        String date = "dd/mm/yyyy:   " + dayOfMonth + " / " + month + " / " + year;
        dateDisplay.setText(date);

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        timeDisplay.setText("Time:  "+ hourOfDay + " : " + minute);
    }
}
