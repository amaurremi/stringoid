package com.quoord.tapatalkpro.activity.forum.home;

import android.app.Activity;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.quoord.tapatalkpro.bean.RecommondImage;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tools.ImageTools;

import java.util.ArrayList;

public class FeedImageAdapter
        extends BaseAdapter {
    private SlidingMenuActivity activity;
    private ArrayList<RecommondImage> imageList = new ArrayList();

    public FeedImageAdapter(Activity paramActivity, ArrayList<RecommondImage> paramArrayList) {
        this.activity = ((SlidingMenuActivity) paramActivity);
        this.imageList = paramArrayList;
    }

    public int getCount() {
        return this.imageList.size();
    }

    public RecommondImage getItem(int paramInt) {
        return (RecommondImage) this.imageList.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return 0L;
    }

    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramViewGroup = LayoutInflater.from(this.activity);
        if (paramView == null) {
            paramView = paramViewGroup.inflate(2130903149, null);
            paramViewGroup = new ViewHolder();
            paramViewGroup.subImage = ((ImageView) paramView.findViewById(2131231027));
            paramViewGroup.sub_title = ((TextView) paramView.findViewById(2131231029));
            paramViewGroup.sub_image_bg = ((ImageView) paramView.findViewById(2131231028));
            paramViewGroup.sub_title.bringToFront();
            paramView.setTag(paramViewGroup);
        }
        for (; ; ) {
            if (((RecommondImage) this.imageList.get(paramInt)).imageUrl != null) {
                ImageTools.glideLoad(((RecommondImage) this.imageList.get(paramInt)).imageUrl, paramViewGroup.subImage);
            }
            paramViewGroup.sub_title.setText(((RecommondImage) this.imageList.get(paramInt)).title);
            paramViewGroup.subImage.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    paramAnonymousView = new Topic();
                    paramAnonymousView.setId(FeedImageAdapter.this.getItem(paramInt).topicId);
                    paramAnonymousView.openThread(FeedImageAdapter.this.activity, FeedImageAdapter.this.activity.forumStatus);
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
        public ImageView sub_image_bg;
        public TextView sub_title;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/home/FeedImageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */