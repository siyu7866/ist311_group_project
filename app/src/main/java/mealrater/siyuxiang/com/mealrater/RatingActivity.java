package mealrater.siyuxiang.com.mealrater;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RatingActivity extends AppCompatActivity {

    private String selectedDishRating;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_rating);
        initEnterRating();
    }

    public void onResume() {
        super.onResume();
        TextView txtSelectedDish = (TextView) findViewById(R.id.textSelectDish);
        TextView txtSelectedRestaurant = (TextView) findViewById(R.id.textSelectRestaurant);
        TextView txtRating = (TextView) findViewById(R.id.textRating);
        Intent intent = getIntent();
        String restaurantName = intent.getStringExtra("restaurantName");
        String restaurantDish = intent.getStringExtra("restaurantDish");
        txtSelectedRestaurant.setText("Select Restaurant: " + restaurantName);
        txtSelectedDish.setText("Select Dish: " + restaurantDish);

        RatingDataSource ds = new RatingDataSource(this);
        try {
            ds.open();
            selectedDishRating = ds.getSpecificDishRating(restaurantDish);
            ds.close();
            txtRating.setText(selectedDishRating);
        }
        catch (Exception e) {
            e.getCause();
            Toast.makeText(this, "Error retrieving rating", Toast.LENGTH_LONG).show();
        }
    }

    private void initEnterRating() {
        Button buttonEnterRating = (Button) findViewById(R.id.buttonEnterRating);
        buttonEnterRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RatingActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

}
