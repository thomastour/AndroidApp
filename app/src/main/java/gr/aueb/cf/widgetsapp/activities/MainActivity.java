package gr.aueb.cf.widgetsapp.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import gr.aueb.cf.widgetsapp.R;

public class MainActivity extends AppCompatActivity {

    private TextView hotel;

    private ImageView arrow;
    private ImageView menuIcon;
    private ImageView hotelPic;
    private TextView superHotel;
    private RatingBar ratingBar;
    private TextView textView;
    private ImageView wifi;
    private ImageView food;
    private ImageView beachUmbrella;
    private AppCompatButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hotel = findViewById(R.id.hotel);


        arrow = findViewById(R.id.arrow);
        menuIcon = findViewById(R.id.menuIcon);
        hotelPic = findViewById(R.id.hotelPic);
        superHotel = findViewById(R.id.superHotel);
        ratingBar = findViewById(R.id.ratingBar);
        textView = findViewById(R.id.textView);
        wifi = findViewById(R.id.wifi);
        food = findViewById(R.id.food);
        beachUmbrella = findViewById(R.id.beachUmbrella);
        button = findViewById(R.id.button);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar,float rating, boolean fromUser) {
                // Perform actions based on the selected rating
                Toast.makeText(MainActivity.this, "Rating: " + rating, Toast.LENGTH_SHORT).show();
            }
        });

        //με πάει στην SecondActivity με το intent
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class); // Create an Intent to start the SecondActivity
                startActivity(intent); // Start the SecondActivity

            }
        });

    }
}