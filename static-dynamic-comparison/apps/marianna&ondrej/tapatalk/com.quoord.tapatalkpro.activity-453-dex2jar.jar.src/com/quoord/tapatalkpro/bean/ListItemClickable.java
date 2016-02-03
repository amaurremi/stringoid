package com.quoord.tapatalkpro.bean;

import android.view.View;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;

import java.util.HashMap;

public abstract interface ListItemClickable {
    public abstract View createView(int paramInt, View paramView, ForumActivityStatus paramForumActivityStatus);

    public abstract View createView(HashMap paramHashMap, View paramView, ForumActivityStatus paramForumActivityStatus);

    public abstract boolean onClick(View paramView, ForumActivityStatus paramForumActivityStatus);

    public abstract boolean onLongClick(View paramView, ForumActivityStatus paramForumActivityStatus);

    public abstract void selfChange(View paramView, ForumActivityStatus paramForumActivityStatus);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/ListItemClickable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */