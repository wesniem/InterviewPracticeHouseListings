package nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wesniemarcelin on 12/20/16.
 */

public class HouseListings {
    private boolean success;
    private List<House> houses;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }
}
