package com.rupesh.rsvideoplay.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rupesh.rsvideoplay.R;
import com.rupesh.rsvideoplay.library.RSVideoPlayer;
import com.rupesh.rsvideoplay.library.RSVideoPlayerStandard;
import com.rupesh.rsvideoplay.util.Video;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Rupesh on 4/27/2017.
 */
@SuppressWarnings("ALL")
public class RecyclerVideoAdapter extends RecyclerView.Adapter<RecyclerVideoAdapter.MyViewHolder> {

    private List<Video> videoLists;
    Activity activity;
    private static final String TAG = "RecyclerVideoAdapter";

    public RecyclerVideoAdapter(List<Video> context, Activity activity) {
        this.videoLists = context;
        this.activity = activity;
    }

    @Override
    public RecyclerVideoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_videoview, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder [" + holder.rsVideoPlayer.hashCode() + "] position=" + position);
        holder.rsVideoPlayer.setUp(videoLists.get(position).getVideoUrl(),
                RSVideoPlayer.SCREEN_LAYOUT_LIST, videoLists.get(position).getVideoTitle());
        Picasso.with(holder.rsVideoPlayer.getContext())
                .load(videoLists.get(position).getVideoThumb())
                .into(holder.rsVideoPlayer.thumbImageView);
    }

    @Override
    public int getItemCount() {
        return videoLists.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        RSVideoPlayerStandard rsVideoPlayer;

        public MyViewHolder(View itemView) {
            super(itemView);
            rsVideoPlayer = (RSVideoPlayerStandard) itemView.findViewById(R.id.videoplayer);
        }
    }

}
