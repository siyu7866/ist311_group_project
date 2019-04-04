package mealrater.siyuxiang.com.mealrater;

public class AverageRating {
    private String restaurant;
    private String rating;

    public AverageRating(){
        rating = "0";
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

}
