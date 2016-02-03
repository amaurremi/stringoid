package com.quoord.tapatalkpro.action;

import android.app.Activity;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.bean.ForumStatus;

import java.util.ArrayList;

public class ColorAction {
    ForumStatus forumStatus;
    String id;
    Activity mContext;

    public ColorAction(Activity paramActivity, String paramString, ForumStatus paramForumStatus) {
        this.forumStatus = paramForumStatus;
        this.id = paramString;
        this.mContext = paramActivity;
        getColor();
    }

    public void getColor() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(TapatalkApp.rebranding_id);
        localArrayList.add("1");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/ColorAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */