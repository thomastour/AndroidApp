package gr.aueb.cf.widgetsapp.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import gr.aueb.cf.widgetsapp.R;
import gr.aueb.cf.widgetsapp.models.Rooms;


public class ThirdActivity extends AppCompatActivity {

    private TextView roomName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        View roomName = findViewById(R.id.roomName);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        String heading = intent.getStringExtra("heading");


    }


}

