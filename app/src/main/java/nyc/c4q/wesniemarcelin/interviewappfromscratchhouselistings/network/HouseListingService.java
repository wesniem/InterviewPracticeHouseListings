package nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings.network;

import nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings.model.HouseListings;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by wesniemarcelin on 12/20/16.
 */

public interface HouseListingService {
    @GET("cgi-bin/class_12_20_2016.pl")
    Call<HouseListings> getHouseListings();
}
