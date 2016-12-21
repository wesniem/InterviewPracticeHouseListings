package nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by wesniemarcelin on 12/20/16.
 */

public class House {
    private String style;
    private String price;
    private String location;

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String  price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
