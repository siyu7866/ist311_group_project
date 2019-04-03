package mealrater.siyuxiang.com.mealrater;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RestaurantListActivity extends AppCompatActivity {
    ArrayList<Rating> restaurants;
    RatingAdapter adapter;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        initRestaurantClick();


        RatingDataSource ds = new RatingDataSource(this);

        try {
            ds.open();
            restaurants = ds.getRating(String, selectedRestaurant);  //Not sure about this one here.
            ds.close();
            ListView listView = (ListView) findViewById(R.id.lvRestaurant);
            listView.setAdapter(new RatingAdapter(this, restaurants));
        }
        catch (Exception e) {
            Toast.makeText(this, "Error retrieving restaurants", Toast.LENGTH_LONG).show();
        }

    }

    private void initRestaurantClick() {
        ListView listView = (ListView) findViewById(R.id.lvRestaurant);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Rating selectedRestaurant = restaurants.get(position);
                Intent intent = new Intent (RestaurantListActivity.this, DishListActivity.class);
                intent.putExtra("dishName", selectedRestaurant.getDishName());
                startActivity(intent);
            }
        });
    }
}
