package com.rupesh.rsvideoplay.util;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rupesh on 4/25/2017.
 */

public class Video {

    @SerializedName("video_id")
    @Expose
    private String videoId;
    @SerializedName("video_title")
    @Expose
    private String videoTitle;
    @SerializedName("video_thumb")
    @Expose
    private String videoThumb;
    @SerializedName("video_url")
    @Expose
    private String videoUrl;
    @SerializedName("ads_url")
    @Expose
    private String adsUrl;
    @SerializedName("vid_user_id")
    @Expose
    private String vidUserId;
    @SerializedName("video_vote")
    @Expose
    private String videoVote;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("view_count")
    @Expose
    private Integer viewCount;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoThumb() {
        return videoThumb;
    }

    public void setVideoThumb(String videoThumb) {
        this.videoThumb = videoThumb;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getAdsUrl() {
        return adsUrl;
    }

    public void setAdsUrl(String adsUrl) {
        this.adsUrl = adsUrl;
    }

    public String getVidUserId() {
        return vidUserId;
    }

    public void setVidUserId(String vidUserId) {
        this.vidUserId = vidUserId;
    }

    public String getVideoVote() {
        return videoVote;
    }

    public void setVideoVote(String videoVote) {
        this.videoVote = videoVote;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

}

