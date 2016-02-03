package com.quoord.tapatalkpro.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.quoord.tapatalkpro.action.GetTopicAction;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;

public class NewTopicView {
    private ArrayList<Forum> recentDatas;

    public View getNewTopicView(final Activity paramActivity, ForumStatus paramForumStatus, final Forum paramForum, final GetTopicAction paramGetTopicAction) {
        View localView = LayoutInflater.from(paramActivity).inflate(2130903126, null);
        ((ImageView) localView.findViewById(2131230987)).setBackgroundDrawable(ThemeUtil.getDrawableByPicName("newtopic_icon", paramActivity));
        LinearLayout localLinearLayout = (LinearLayout) localView.findViewById(2131230986);
        paramActivity = AppCacheManager.getRecentForumCacheUrl(paramActivity, paramForumStatus.getUrl(), paramForumStatus.tapatalkForum.getCacheUsernameDir());
        this.recentDatas = ((ArrayList) AppCacheManager.getCacheData(paramActivity));
        if (this.recentDatas == null) {
            this.recentDatas = new ArrayList();
        }
        localLinearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (!NewTopicView.this.recentDatas.contains(paramForum)) {
                    NewTopicView.this.recentDatas.add(paramForum);
                }
                AppCacheManager.cacheData(paramActivity, NewTopicView.this.recentDatas);
                paramGetTopicAction.startNewTopic();
            }
        });
        return localView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/NewTopicView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */