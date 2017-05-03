package com.rupesh.rsvideoplay.library;

/**
 * Created by Rupesh on 4/25/2017.
 */
@SuppressWarnings("ALL")
public class RSVideoPlayerManager {

    public static RSVideoPlayer FIRST_FLOOR_RSVD;
    public static RSVideoPlayer SECOND_FLOOR_RSVD;

    public static void setFirstFloor(RSVideoPlayer RSVideoPlayer) {
        FIRST_FLOOR_RSVD = RSVideoPlayer;
    }

    public static void setSecondFloor(RSVideoPlayer RSVideoPlayer) {
        SECOND_FLOOR_RSVD = RSVideoPlayer;
    }

    public static RSVideoPlayer getFirstFloor() {
        return FIRST_FLOOR_RSVD;
    }

    public static RSVideoPlayer getSecondFloor() {
        return SECOND_FLOOR_RSVD;
    }

    public static RSVideoPlayer getCurrentRsvd() {
        if (getSecondFloor() != null) {
            return getSecondFloor();
        }
        return getFirstFloor();
    }

    public static void completeAll() {
        if (SECOND_FLOOR_RSVD != null) {
            SECOND_FLOOR_RSVD.onCompletion();
            SECOND_FLOOR_RSVD = null;
        }
        if (FIRST_FLOOR_RSVD != null) {
            FIRST_FLOOR_RSVD.onCompletion();
            FIRST_FLOOR_RSVD = null;
        }
    }
}
