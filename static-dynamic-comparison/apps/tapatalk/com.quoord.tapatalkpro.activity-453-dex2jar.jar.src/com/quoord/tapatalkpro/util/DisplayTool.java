package com.quoord.tapatalkpro.util;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public abstract interface DisplayTool {
    public abstract YouTubePlayer getPlayer();

    public abstract YouTubePlayerView getPlayerView();

    public abstract void initialPlayerView();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/DisplayTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */