package com.quoord.tapatalkpro.bean;

import android.view.View;
import android.widget.LinearLayout;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.adapter.forum.ThreadAdapter;
import com.quoord.tapatalkpro.ui.ThreadPaginationView;

import java.io.Serializable;

public class ThreadFootView
        implements Serializable {
    public static View getFootView(ThreadOuterFragment paramThreadOuterFragment, ThreadAdapter paramThreadAdapter, int paramInt, ForumStatus paramForumStatus, String paramString1, String paramString2) {
        paramThreadAdapter = new LinearLayout(paramThreadOuterFragment.getActivity());
        paramThreadAdapter.setOrientation(1);
        paramThreadAdapter.setGravity(17);
        if (paramThreadOuterFragment.mTopicController.isFootNeeded()) {
            paramThreadAdapter.addView(ThreadPaginationView.get(paramThreadOuterFragment, paramInt));
        }
        return paramThreadAdapter;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/ThreadFootView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */