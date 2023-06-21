package gr.aueb.cf.widgetsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Toolbar toolbar2;
    private ImageView arrow;
    private ImageView menuIcon;

    private TextView availability;

    private DatePicker datePicker;
    private TextView reservationDate;

    private ImageView roomImage;

    private Button btnDatePicker;

    Calendar calendar = Calendar.getInstance(); // Calendar instance

    DatePickerDialog datePickerDialog;  // Date picker dialog
    DatePickerDialog.OnDateSetListener dateSetListener; // Listener for date selection

    DatePickerDialog.OnCancelListener cancelListener; // Listener for date selection cancellation


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnDatePicker = findViewById(R.id.btnDatePicker);
        toolbar = findViewById(R.id.toolbar);
        toolbar2 = findViewById(R.id.toolbar2);
        arrow = findViewById(R.id.arrow);
        menuIcon = findViewById(R.id.menuIcon);
        availability = findViewById(R.id.availability);
        reservationDate = findViewById(R.id.reservationDate);
        roomImage = findViewById(R.id.roomImage);


        // Set the toolbar as the action bar
        dateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDayOfMonth) {
                selectedMonth = selectedMonth + 1; // Because months start from 0
                reservationDate.setText("Your reservation is set for " + selectedDayOfMonth + "/" + selectedMonth + "/" + selectedYear);
            }
        };


        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(SecondActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, dateSetListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                datePickerDialog.setOnCancelListener(cancelListener);
                datePickerDialog.show();
            }


        });

        cancelListener = new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                reservationDate.setText("Pick your reservation NOW!");


            }
        };


    }



}


