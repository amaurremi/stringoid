package com.quoord.tapatalkpro.activity.forum.feed;

import android.app.Activity;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.util.ForumUrlUtil;
import com.quoord.tools.ImageTools;

import java.util.ArrayList;
import java.util.HashMap;

public class FeedCategoryAdapter
        extends BaseAdapter {
    private SlidingMenuActivity activity;
    private ArrayList<Forum> forumList = new ArrayList();

    public FeedCategoryAdapter(Activity paramActivity, ArrayList<Forum> paramArrayList) {
        this.activity = ((SlidingMenuActivity) paramActivity);
        this.forumList = paramArrayList;
    }

    public int getCount() {
        return this.forumList.size();
    }

    public Forum getItem(int paramInt) {
        return (Forum) this.forumList.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return 0L;
    }

    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramViewGroup = LayoutInflater.from(this.activity);
        if (paramView == null) {
            paramView = paramViewGroup.inflate(2130903159, null);
            paramViewGroup = new ViewHolder();
            paramViewGroup.subImage = ((ImageView) paramView.findViewById(2131231027));
            paramViewGroup.sub_title = ((TextView) paramView.findViewById(2131231029));
            paramView.setTag(paramViewGroup);
        }
        for (; ; ) {
            if (((Forum) this.forumList.get(paramInt)).getForum_image() != null) {
                ImageTools.glideLoad(((Forum) this.forumList.get(paramInt)).getForum_image(), paramViewGroup.subImage);
            }
            if (!SettingsFragment.isLightTheme(this.activity)) {
                paramViewGroup.sub_title.setTextColor(this.activity.getResources().getColor(2131165213));
            }
            paramViewGroup.sub_title.setText(((Forum) this.forumList.get(paramInt)).getName());
            paramViewGroup.subImage.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    paramAnonymousView = new HashMap();
                    paramAnonymousView.put("fid", FeedCategoryAdapter.this.getItem(paramInt).getId());
                    ForumUrlUtil.openForumByIds(FeedCategoryAdapter.this.activity, FeedCategoryAdapter.this.activity.forumStatus, paramAnonymousView, "feed_forum_stack_tag", false);
                }
            });
            return paramView;
            paramViewGroup = (ViewHolder) paramView.getTag();
        }
    }

    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {
        if (paramDataSetObserver != null) {
            super.unregisterDataSetObserver(paramDataSetObserver);
        }
    }

    public static class ViewHolder {
        public ImageView subImage;
        public TextView sub_title;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/feed/FeedCategoryAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */