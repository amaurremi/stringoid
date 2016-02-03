package com.quoord.tapatalkpro.bean;

import android.view.View;

import java.util.ArrayList;

public abstract interface ParseableData {
    public abstract void addImageBeanToFinished(ImageInThread paramImageInThread);

    public abstract int getFloor();

    public abstract ArrayList<ImageInThread> getImageBeans();

    public abstract ArrayList<ImageInThread> getImageBeansFinished();

    public abstract String getPostId();

    public abstract int getPostTimeStamp();

    public abstract boolean isDeleted();

    public abstract void setAttachLay(View paramView);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/ParseableData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */