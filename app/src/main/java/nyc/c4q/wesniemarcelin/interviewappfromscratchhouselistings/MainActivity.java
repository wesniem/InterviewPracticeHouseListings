package nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings;

import android.app.ListFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings.model.House;

public class MainActivity extends AppCompatActivity {
    RecyclerView houseRV;
    List<House> mHouseListings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState ==null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.activity_main, new ListingFragment())
                    .commit();
        }
    }
}
