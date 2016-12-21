package nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings.recyclerViewItems;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings.R;
import nyc.c4q.wesniemarcelin.interviewappfromscratchhouselistings.model.House;
/**
 * Created by wesniemarcelin on 12/20/16.
 */

public class ListingAdapter extends RecyclerView.Adapter<ListingViewHolder> {
    private List<House> mHouseListings;

    public ListingAdapter(List<House> mHouseListings) {
        this.mHouseListings = mHouseListings;
    }

    @Override
    public ListingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.house_item, parent, false);
        return new ListingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListingViewHolder holder, int position) {
        House house = mHouseListings.get(position);
        holder.bind(house);
    }

    @Override
    public int getItemCount() {
        return mHouseListings.size();
    }

    public void setData(List<House> listings) {
        this.mHouseListings = listings;
        notifyDataSetChanged();
    }
}
