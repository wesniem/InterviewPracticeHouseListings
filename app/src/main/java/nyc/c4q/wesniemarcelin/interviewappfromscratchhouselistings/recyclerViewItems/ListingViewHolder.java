package nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings.recyclerViewItems;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings.R;
import nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings.model.House;

/**
 * Created by wesniemarcelin on 12/20/16.
 */

public class ListingViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG ="YOO" ;
    TextView styleView;
    TextView priceView;
    TextView locationView;
    private House house;
    View view;

    public ListingViewHolder(View itemView) {
        super(itemView);
        styleView = (TextView) itemView.findViewById(R.id.style);
        priceView = (TextView) itemView.findViewById(R.id.price);
        locationView = (TextView) itemView.findViewById(R.id.location);
        view = itemView;
    }

    public void bind(House house) {
        this.house = house;
        styleView.setText(house.getStyle());
        priceView.setText(house.getPrice());
        locationView.setText(house.getLocation());
        Log.d(TAG, "binded houses");
    }
}
