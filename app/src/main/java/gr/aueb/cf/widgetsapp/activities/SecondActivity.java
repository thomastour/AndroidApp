package gr.aueb.cf.widgetsapp.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import gr.aueb.cf.widgetsapp.R;
import gr.aueb.cf.widgetsapp.adapters.MyAdapter;
import gr.aueb.cf.widgetsapp.models.Rooms;

public class SecondActivity extends AppCompatActivity {


    private ImageView arrow;
    private ImageView menuIcon;

    private TextView availability;

    private DatePicker datePicker;
    private TextView reservationDate;

    private Button btnDatePicker;
    private String[] roomsHeading;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private ArrayList<Rooms> roomsArrayList;

    Calendar calendar = Calendar.getInstance(); // Calendar instance

    DatePickerDialog datePickerDialog;  // Date picker dialog
    DatePickerDialog.OnDateSetListener dateSetListener; // Listener for date selection

    DatePickerDialog.OnCancelListener cancelListener; // Listener for date selection cancellation


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnDatePicker = findViewById(R.id.btnDatePicker);


        reservationDate = findViewById(R.id.reservationDate);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        roomsArrayList = new ArrayList<>();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Rooms");

        setData();
        getData();




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

    private void getData() {
        for (int i=0; i < roomsHeading.length; i++) {
            Rooms rooms = new Rooms(roomsHeading[i]);
            roomsArrayList.add(rooms);
        }
        myAdapter = new MyAdapter(this, roomsArrayList); // Create adapter passing in the sample user data
        recyclerView.setAdapter(myAdapter);

        myAdapter.notifyDataSetChanged();
    }

    private void setData() {
        roomsHeading = new String[]{
                "Deluxe Double Room with Balcony and Sea View",
                "Deluxe King Suite",
                "Deluxe Double Room",
                "Deluxe Double or Twin Room",
                "Deluxe Double Room with Sea View",
                "Holiday Home",
                "President Suite",
                "Deluxe King Suite||",
                "Deluxe Family Room",
                "Holiday Family Home",
                "King Size Holiday Home"


        };

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search_action);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Search here");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { // When user submits the query
                myAdapter.getFilter().filter(query); // Filter the results
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) { // When user changes the text
                myAdapter.getFilter().filter(newText); // Filter the results


                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);

    }

}


