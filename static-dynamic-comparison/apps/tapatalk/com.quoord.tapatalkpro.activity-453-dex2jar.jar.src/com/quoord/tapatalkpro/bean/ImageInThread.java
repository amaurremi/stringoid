package com.quoord.tapatalkpro.bean;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.quoord.tapatalkpro.ui.CustomImageViewLayout;

public class ImageInThread
        extends BaseBean
        implements Comparable<ImageInThread> {
    public ImageView clickView;
    public String description = null;
    public CustomImageViewLayout iv;
    public ProgressBar pb;
    public int position;
    public String sourceUrl;
    public String type;

    public int compareTo(ImageInThread paramImageInThread) {
        return this.position - paramImageInThread.position;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/ImageInThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */