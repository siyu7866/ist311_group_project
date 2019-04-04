package mealrater.siyuxiang.com.mealrater;

public class AverageRating {
    private String restaurant;
    private String rating;
    private String dish;
    private String dishRating;

    public AverageRating(){
        rating = "0";
        dishRating = "0";
    }

    public String getRestaurant (){
        return restaurant;
    }

    public void setRestaurant(String s){
        restaurant = s;
    }

    public String getRating(){
        return rating;
    }

    public void setRating(String s){
        rating = s;
    }

    public String getRestaurantDish () {
        return dish;
    }

    public void setRestaurantDish (String s) {
        dish = s;
    }

    public String getDishRating () {
        return dishRating;
    }

    public void setDishRating (String s) {
        dishRating = s;
    }

}
