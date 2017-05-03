package com.rupesh.rsvideoplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.rupesh.rsvideoplay.adapter.RecyclerVideoAdapter;
import com.rupesh.rsvideoplay.library.RSVideoPlayer;
import com.rupesh.rsvideoplay.library.RSVideoPlayerManager;
import com.rupesh.rsvideoplay.rest.ApiClient;
import com.rupesh.rsvideoplay.rest.ApiInterface;
import com.rupesh.rsvideoplay.util.Video;
import com.rupesh.rsvideoplay.util.VideoList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerVideoAdapter videoAdapter;

    String user_id = "635";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<VideoList> call = apiService.getVideoList(user_id);
        call.enqueue(new Callback<VideoList>() {
            @Override
            public void onResponse(Call<VideoList> call, Response<VideoList> response) {
                List<Video> videoList = response.body().getVideos();
                videoAdapter = new RecyclerVideoAdapter(videoList, MainActivity.this);
                recyclerView.setAdapter(videoAdapter);
            }

            @Override
            public void onFailure(Call<VideoList> call, Throwable t) {
                Log.e(MainActivity.class.getSimpleName(), t.toString());
            }
        });


        recyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                if (RSVideoPlayerManager.getFirstFloor() != null) {
                    RSVideoPlayer videoPlayer = RSVideoPlayerManager.getFirstFloor();
                    if (((ViewGroup) view).indexOfChild(videoPlayer) != -1 && videoPlayer.currentState == RSVideoPlayer.CURRENT_STATE_PLAYING) {
                        RSVideoPlayer.releaseAllVideos();
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (RSVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        RSVideoPlayer.releaseAllVideos();
    }
}
