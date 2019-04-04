package mealrater.siyuxiang.com.mealrater;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class DishAdapter extends ArrayAdapter<AverageRating> {
    private ArrayList<AverageRating> items;
    private Context adapterContext;

    public DishAdapter(Context context, ArrayList<AverageRating> items) {
        super(context, R.layout.list_item_dish, items);
        adapterContext = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        try {
            AverageRating ratings = items.get(position);

            if (v == null) {
                LayoutInflater vi = (LayoutInflater)
                        adapterContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.list_item_dish, null);
            }

            TextView dishName = (TextView) v.findViewById(R.id.textDishName);
            TextView ratingDishNumber = (TextView) v.findViewById(R.id.textAverageDishRating);
            Button b = (Button) v.findViewById(R.id.buttonEnterRating);
            dishName.setText(ratings.getRestaurantDish());
            ratingDishNumber.setText(ratings.getDishRating());
            b.setVisibility(View.INVISIBLE);
        }
        catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return v;
    }
}