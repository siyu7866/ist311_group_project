package mealrater.siyuxiang.com.mealrater;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DishListActivity extends AppCompatActivity {
        ArrayList<Rating> dishes ;
        DishAdapter adapter;

        protected void onCreate(Bundle saveInstanceState) {
            super.onCreate(saveInstanceState);
            setContentView(R.layout.activity_dish_list);

            RatingDataSource ds = new RatingDataSource(this);

            try {
                ds.open();
                dishes = ds.getRestaurant();
                ds.close();
                ListView listView = (ListView) findViewById(R.id.lvRestaurantDishes);
                listView.setAdapter(new DishAdapter(this, dishes));
            }
            catch (Exception e) {
                Toast.makeText(this, "Error retrieving dishes", Toast.LENGTH_LONG).show();
            }

        }






}
