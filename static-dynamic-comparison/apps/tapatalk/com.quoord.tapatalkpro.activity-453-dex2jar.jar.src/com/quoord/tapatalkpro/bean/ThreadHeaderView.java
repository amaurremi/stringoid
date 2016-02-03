package com.quoord.tapatalkpro.bean;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.adapter.forum.ThreadAdapter;
import com.quoord.tapatalkpro.ui.ThreadPaginationView;

import java.io.Serializable;

public class ThreadHeaderView
        implements Serializable {
    public static View getHeaderView(ThreadOuterFragment paramThreadOuterFragment, ThreadAdapter paramThreadAdapter, int paramInt) {
        paramThreadAdapter = (LinearLayout) paramThreadOuterFragment.getActivity().getLayoutInflater().inflate(2130903401, null);
        if (paramThreadOuterFragment.mTopicController.isFootNeeded()) {
            paramThreadOuterFragment = ThreadPaginationView.get(paramThreadOuterFragment, paramInt);
            paramThreadAdapter.removeViewAt(0);
            paramThreadAdapter.addView(paramThreadOuterFragment, 0);
        }
        return paramThreadAdapter;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/ThreadHeaderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */