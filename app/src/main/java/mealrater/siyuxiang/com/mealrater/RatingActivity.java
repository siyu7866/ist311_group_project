package mealrater.siyuxiang.com.mealrater;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class RatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_rating);
//        initEnterRating();
    }

//    //Siyu
//    //initialize Enter Rating Button
//    private void initEnterRating() {
//        Button buttonEnterRating = (Button) findViewById(R.id.buttonEnterRating);
//        buttonEnterRating.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(RatingActivity.this, RestaurantListActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
//            }
//        });
//    }


}
