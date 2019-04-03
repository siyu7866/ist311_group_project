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


public class RatingAdapter extends ArrayAdapter<Rating> {
    private ArrayList<Rating> items;
    private Context adapterContext;

    public RatingAdapter(Context context, ArrayList<Rating> items) {
        super(context, R.layout.activity_restaurant_list, items);
        adapterContext = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        try {
            Rating rating = items.get(position);

            if (v == null) {
                LayoutInflater vi = (LayoutInflater)
                        adapterContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.list_item, null);
            }

            TextView restaurantName = (TextView) v.findViewById(R.id.textRestaurantName);
            TextView ratingNumber = (TextView) v.findViewById(R.id.textAverageRating);
            Button b = (Button) v.findViewById(R.id.buttonEnterRating);
            restaurantName.setText(Rating.getRestaurantName());
            ratingNumber.setText(Rating.getAverageRatingNumber());
            b.setVisibility(View.INVISIBLE);
        }
        catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return v;
    }
}