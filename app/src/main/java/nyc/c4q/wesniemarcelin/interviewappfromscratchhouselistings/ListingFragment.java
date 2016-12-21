package nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings.model.House;
import nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings.model.HouseListings;
import nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings.network.HouseListingService;
import nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings.recyclerViewItems.ListingAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wesniemarcelin on 12/20/16.
 */

public class ListingFragment extends Fragment {
    private static final String TAG ="YOOOOO" ;
    private static final String BASE_URL ="http://jsjrobotics.nyc/";
    RecyclerView houseRV = null;
    ListingAdapter listingAdapter;
    List<House> mHouseListings;
    Context context;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View mroot = inflater.inflate(R.layout.house_fragment_layout, container, false);
        houseRV = (RecyclerView) mroot.findViewById(R.id.recyclerview_houses);
        fetchHouses();
        return mroot;
    }

    private void fetchHouses() {
        //Retrofit Call
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Service Call
        HouseListingService service = retrofit.create(HouseListingService.class);
        Call<HouseListings> call = service.getHouseListings();

        //Asynchronous Call for success or failure
        call.enqueue(new Callback<HouseListings>() {
            @Override
            public void onResponse(Call<HouseListings> call, Response<HouseListings> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "Success " + response.body().toString());

                        //What to do in case of success
                        HouseListings houselisting = response.body();
                        mHouseListings = houselisting.getHouses();

                        Log.d("POJO", "Pojos " + mHouseListings.get(0).getLocation());
                        Log.d("Success", "Made It");

                        houseRV.setLayoutManager(new LinearLayoutManager(context));

                        listingAdapter = new ListingAdapter(mHouseListings);
                        houseRV.setAdapter(listingAdapter);

                        Log.d("Adapter", "adapter attached");
                    } else {
                        Log.e(TAG, "Error" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<HouseListings> call, Throwable t) {
                Log.d("Failure", t.getMessage());
            }
        });





    }
}
