package mealrater.siyuxiang.com.mealrater;

public class Rating {

    private int ratingID;
    private String restaurant;
    private String dishName;
    private int avg_ratingNumber;
    private int rating;

    public Rating () {
        rating = 0;
        ratingID = -1;
    }

    public int getRatingID () {
        return ratingID;
    }

    public void setRatingID (int i) {
        ratingID = i;
    }

    public String getRestaurant () {
        return restaurant;
    }

    public void setRestaurant (String s) {
        restaurant = s;
    }

    public String getDishName () {
        return dishName;
    }

    public void setDishName(String s) {
        dishName = s;
    }

    public int getRating () {
        return rating;
    }

    public void setRating(int i) {
        rating = i;
    }

    public int getAverageRatingNumber () {
        return avg_ratingNumber;
    }

    public void setAverageRatingNumber (int i) {
        avg_ratingNumber = i;
    }
}
