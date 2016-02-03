package com.quoord.tapatalkpro.ics.forum;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.util.ForumUrlUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class ForumFragmentUtil {
    public static final String CATEGORY = "category";
    public static final String NAME = "name";
    public static final String SUBSCRIBE = "subscribe";

    public static void forumClickFragment(Forum paramForum, SlidingMenuActivity paramSlidingMenuActivity, String paramString1, String paramString2) {
        if (((paramForum.getChildForums() == null) || (paramForum.getChildForums().size() <= 0)) && (paramForum.getUrl() != null) && (paramForum.getUrl().length() > 0)) {
            HashMap localHashMap = ForumUrlUtil.getIdFromUrl(paramForum.getUrl());
            String str = paramSlidingMenuActivity.getForumStatus().getUrl().replace("www.", "").replace("http://", "");
            if ((paramForum.getUrl().contains(str)) && (localHashMap.containsKey("fid"))) {
                openSubForum(paramForum, paramString1, paramSlidingMenuActivity, paramSlidingMenuActivity.getForumStatus());
                return;
            }
            if (localHashMap.size() > 0) {
                try {
                    ForumUrlUtil.openForumByIds(paramSlidingMenuActivity, paramSlidingMenuActivity.getForumStatus(), localHashMap, paramString2, false);
                    return;
                } catch (Exception paramString1) {
                    try {
                        paramSlidingMenuActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramForum.getUrl())));
                        return;
                    } catch (Exception paramForum) {
                        return;
                    }
                }
            }
            try {
                paramSlidingMenuActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramForum.getUrl())));
                return;
            } catch (Exception paramForum) {
                return;
            }
        }
        openSubForum(paramForum, paramString1, paramSlidingMenuActivity, paramSlidingMenuActivity.getForumStatus());
    }

    public static void openSubForum(Forum paramForum, String paramString, Activity paramActivity, ForumStatus paramForumStatus) {
        ((SlidingMenuActivity) paramActivity).addFragmentToStack(SubForumFragment.newInstance(paramForum, paramString), paramString, true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/forum/ForumFragmentUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */