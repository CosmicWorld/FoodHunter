package sg.edu.rp.c346.foodhunter;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by 15017381 on 16/11/2016.
 */
public class Food {
    private String name;
    private String location;
    private String description;
    private int img;

    public Food(String name, String location, String description){
        this.name = name;
        this.location = location;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
