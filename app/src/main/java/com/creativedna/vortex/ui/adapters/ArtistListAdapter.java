package com.creativedna.vortex.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.creativedna.vortex.R;
import com.creativedna.vortex.models.Artist;
import com.creativedna.vortex.ui.adapters.ViewHolders.ArtistViewHolder;
import com.creativedna.vortex.ui.adapters.ViewHolders.EventHeader;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.ArrayList;



/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD on 10/29/2015.
 */
public class ArtistListAdapter extends RecyclerView.Adapter<ArtistViewHolder> implements StickyRecyclerHeadersAdapter<EventHeader> {
    private ArrayList<Artist> artists;
    private Context context;

    public ArtistListAdapter(ArrayList<Artist> artists, Context context) {
        this.artists = artists;
        this.context = context;
    }

    @Override
    public ArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ArtistViewHolder(context, LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_single_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ArtistViewHolder holder, int position) {
        holder.render(artists.get(position));
    }

    @Override
    public long getHeaderId(int position) {

        return getItem(position).charAt(0);

    }

    private CharSequence getItem(int position) {

        Artist artist = artists.get(position);
        System.out.println("Artist Name: "+ artist.getCategory_name());
        return artist.getCategory_name();
    }


    @Override
    public EventHeader onCreateHeaderViewHolder(ViewGroup parent) {
        return new EventHeader(LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_sticky_header, parent, false));
    }

    @Override
    public void onBindHeaderViewHolder(EventHeader holder, int position) {
        holder.renderView(artists.get(position).getCategory_name().substring(0, 1));
    }

    @Override
    public int getItemCount() {
        return artists.size() == 0 ? 0 : artists.size();
    }
}
