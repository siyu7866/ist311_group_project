package mealrater.siyuxiang.com.mealrater;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DishListActivity extends AppCompatActivity {
//    ArrayList<Rating> dish;
//    DishAdapter adapter;
    ArrayList<AverageRating> ratings;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_dish_list);
        initEnterRating();

//            RatingDataSource ds = new RatingDataSource(this);
//
//            try {
//                ds.open();
//                dishes = ds.getRestaurantName();
//                ds.close();
//                ListView listView = (ListView) findViewById(R.id.lvRestaurantDishes);
//                listView.setAdapter(new DishAdapter(this, dishes));
//            }
//            catch (Exception e) {
//                Toast.makeText(this, "Error retrieving dishes", Toast.LENGTH_LONG).show();
//            }
//
//        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater();
        return true;
    }

    public void onResume(){
        super.onResume();

        TextView txtRestaurantTitle = (TextView) findViewById(R.id.restaurantTitle);
        Intent intent = getIntent();
        String restaurantName = intent.getStringExtra("restaurantName");
        txtRestaurantTitle.setText(restaurantName);

        RatingDataSource ds = new RatingDataSource(this);
        try {
            ds.open();
//            Ratings = ds.getRatings();
//            adapter = new RatingAdapter(this, Ratings);
            //Intent intent = getIntent();
            //String restaurantName = intent.getStringExtra("restaurantName");
            ratings = ds.getDishRatings(restaurantName);
            ds.close();


            ListView listView = (ListView) findViewById(R.id.lvRestaurantDishes);
            listView.setAdapter(new DishAdapter(this, ratings));
        }
        catch (Exception e) {
            e.getCause();
            Toast.makeText(this, "Error retrieving restaurants", Toast.LENGTH_LONG).show();
        }
    }

    private void initEnterRating() {
        Button buttonEnterRating = (Button) findViewById(R.id.buttonEnterRating);
        buttonEnterRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DishListActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
