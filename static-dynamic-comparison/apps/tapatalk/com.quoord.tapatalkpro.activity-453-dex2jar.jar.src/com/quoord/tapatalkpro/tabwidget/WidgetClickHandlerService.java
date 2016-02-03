package com.quoord.tapatalkpro.tabwidget;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.forum.PMContentActivity;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.activity.forum.conversation.ConverSationActivity;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.tabwidget.manager.FavTopicsWidgetManager;
import com.quoord.tapatalkpro.util.Util;

import java.io.Serializable;
import java.util.List;

public class WidgetClickHandlerService
        extends Service {
    public static final String ACTION_CLICK_LOGIN = "android.appwidget.action.CLICK_LOGIN";
    public static final String ACTION_CLICK_LOGO = "android.appwidget.action.CLICK_LOGO";
    public static final String ACTION_CLICK_NEWPM = "android.appwidget.action.CLICK_NEWPM";
    public static final String ACTION_CLICK_TOPIC_REFERESH = "android.appwidget.action.TOPIC_REFERESH";

    public IBinder onBind(Intent paramIntent) {
        return null;
    }

    public void onStart(Intent paramIntent, int paramInt) {
        super.onStart(paramIntent, paramInt);
        Object localObject1;
        Object localObject2;
        if (paramIntent != null) {
            paramInt = paramIntent.getIntExtra("forumId", -1);
            localObject1 = null;
            if (paramInt != -1) {
                break label97;
            }
            if (paramIntent.getAction().equals("android.appwidget.action.TOPIC_REFERESH")) {
                paramInt = FavTopicsWidgetManager.loadForumIdPref(this, paramIntent.getIntExtra("widgetId", -1));
                localObject2 = new FavoriateSqlHelper(this, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(paramInt);
                localObject1 = localObject2;
                if (localObject2 != null) {
                    break label138;
                }
            }
        }
        label97:
        label138:
        label681:
        label963:
        do {
            do {
                do {
                    do {
                        for (; ; ) {
                            return;
                            try {
                                localObject2 = new FavoriateSqlHelper(this, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(paramInt);
                                localObject1 = localObject2;
                            } catch (Exception localException) {
                                for (; ; ) {
                                    localException.printStackTrace();
                                }
                                if (paramIntent.getAction() == null) {
                                    break label681;
                                }
                            }
                            ForumStatus localForumStatus = ForumStatus.initialForumStatus(this, (TapatalkForum) localObject1, null, null, true);
                            if ((localForumStatus.tapatalkForum.getUserName() != null) && (localForumStatus.tapatalkForum.hasPassword())) {
                                localForumStatus.setLogin(true);
                            }
                            if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("android.appwidget.action.FORUM_CLICK"))) {
                                localObject2 = (Forum) paramIntent.getExtras().getSerializable("forumserial");
                                paramIntent.setClass(this, SlidingMenuActivity.class);
                                paramIntent.putExtra("defaultclick", 1019);
                                paramIntent.putExtra("fromWidget", true);
                                paramIntent.putExtra("subscribeForum", (Serializable) localObject2);
                                paramIntent.putExtra("forum", (Serializable) localObject1);
                                paramIntent.addFlags(268435456);
                                startActivity(paramIntent);
                                return;
                            }
                            if (paramIntent.getAction().equals("android.appwidget.action.FAV_TOPIC_CLICK")) {
                                localIntent = null;
                                paramInt = -1;
                            }
                            try {
                                i = paramIntent.getIntExtra("widgetId", -1);
                                paramInt = i;
                                paramIntent = paramIntent.getExtras().getSerializable("serial");
                                if (paramIntent == null) {
                                    continue;
                                }
                                paramInt = i;
                                paramIntent = (Topic) paramIntent;
                                paramInt = i;
                            } catch (Exception paramIntent) {
                                for (; ; ) {
                                    int i;
                                    paramIntent = localIntent;
                                }
                            }
                            if (paramIntent != null) {
                                localIntent = new Intent();
                                localIntent.setClass(this, SlidingMenuActivity.class);
                                localIntent.putExtra("topic_id", paramIntent.getId());
                                localIntent.putExtra("topic_title", paramIntent.getTitle());
                                localIntent.putExtra("reply_count", paramIntent.getReplyCount());
                                localIntent.putExtra("forumId", paramIntent.getForumId());
                                localIntent.putExtra("fromWidget", true);
                                localIntent.putExtra("viewsubscribe", true);
                                localIntent.putExtra("forum", (Serializable) localObject1);
                                localIntent.addFlags(268435456);
                                startActivity(localIntent);
                                localIntent = new Intent();
                                localIntent.setClass(this, ThreadActivity.class);
                                localIntent.putExtra("topic_id", paramIntent.getId());
                                localIntent.putExtra("topic_title", paramIntent.getTitle());
                                localIntent.putExtra("reply_count", paramIntent.getReplyCount());
                                localIntent.putExtra("forumId", paramIntent.getForumId());
                                localIntent.putExtra("fromWidget", true);
                                localIntent.putExtra("viewsubscribe", true);
                                localIntent.putExtra("forumStatus", localForumStatus);
                                localIntent.putExtra("forum", (Serializable) localObject1);
                                localIntent.addFlags(268435456);
                                startActivity(localIntent);
                                if (paramIntent.getNewPost()) {
                                    localObject1 = FavTopicsWidgetManager.getInstance().getOrCreateWidget(this, paramInt);
                                    paramIntent.setNewPost(false);
                                    i = 0;
                                    for (; ; ) {
                                        if (i >= ((FavTopicsWidget) localObject1).mList.size()) {
                                            FavTopicsWidgetManager.getInstance().updateWidgets(this, new int[]{paramInt});
                                            return;
                                        }
                                        if (((((FavTopicsWidget) localObject1).mList.get(i) instanceof Topic)) && (((Topic) ((FavTopicsWidget) localObject1).mList.get(i)).getId().equals(paramIntent.getId()))) {
                                            ((FavTopicsWidget) localObject1).mList.set(i, paramIntent);
                                        }
                                        i += 1;
                                    }
                                    if ((paramIntent == null) || (paramIntent.getAction() == null) || (!paramIntent.getAction().equals("android.appwidget.action.PM_CLICK"))) {
                                        break label963;
                                    }
                                    localIntent = null;
                                }
                            }
                            try {
                                paramIntent = paramIntent.getExtras().getSerializable("serial");
                                if (paramIntent != null) {
                                    paramIntent = (PrivateMessage) paramIntent;
                                }
                            } catch (Exception paramIntent) {
                                for (; ; ) {
                                    Bundle localBundle;
                                    paramIntent = localIntent;
                                }
                            }
                        }
                    } while (paramIntent == null);
                    localIntent = new Intent();
                    localIntent.setClass(this, SlidingMenuActivity.class);
                    localBundle = new Bundle();
                    localBundle.putSerializable("pm", paramIntent);
                    localIntent.putExtras(localBundle);
                    localIntent.putExtra("fromWidget", true);
                    localIntent.putExtra("viewpm", true);
                    localIntent.putExtra("forum", (Serializable) localObject1);
                    localIntent.putExtra("forumId", ((TapatalkForum) localObject1).getId());
                    localIntent.addFlags(268435456);
                    startActivity(localIntent);
                    localIntent = new Intent();
                    localIntent.setClass(this, PMContentActivity.class);
                    localBundle = new Bundle();
                    localBundle.putSerializable("pm", paramIntent);
                    localBundle.putSerializable("forumStatus", localForumStatus);
                    localIntent.putExtras(localBundle);
                    localIntent.putExtra("fromWidget", true);
                    localIntent.putExtra("viewpm", true);
                    localIntent.putExtra("forum", (Serializable) localObject1);
                    localIntent.putExtra("forumId", ((TapatalkForum) localObject1).getId());
                    localIntent.addFlags(268435456);
                    startActivity(localIntent);
                    return;
                    if ((paramIntent != null) && (paramIntent.getAction() != null) && (paramIntent.getAction().equals("android.appwidget.action.CONVER_CLICK"))) {
                        localIntent = new Intent();
                        localIntent.setClass(this, SlidingMenuActivity.class);
                        localIntent.putExtras(new Bundle());
                        localIntent.putExtra("conv_id", paramIntent.getStringExtra("convId"));
                        localIntent.putExtra("viewConvos", true);
                        localIntent.putExtra("fromWidget", true);
                        localIntent.putExtra("forum", (Serializable) localObject1);
                        localIntent.putExtra("forumId", ((TapatalkForum) localObject1).getId());
                        localIntent.addFlags(268435456);
                        startActivity(localIntent);
                        localIntent = new Intent();
                        localIntent.setClass(this, ConverSationActivity.class);
                        localBundle = new Bundle();
                        localBundle.putSerializable("forumStatus", localForumStatus);
                        localIntent.putExtras(localBundle);
                        localIntent.putExtra("conv_id", paramIntent.getStringExtra("convId"));
                        localIntent.putExtra("viewConvos", true);
                        localIntent.putExtra("fromWidget", true);
                        localIntent.putExtra("forum", (Serializable) localObject1);
                        localIntent.putExtra("forumId", ((TapatalkForum) localObject1).getId());
                        localIntent.addFlags(268435456);
                        startActivity(localIntent);
                        return;
                    }
                    if ((paramIntent == null) || (paramIntent.getAction() == null) || (!paramIntent.getAction().equals("android.appwidget.action.CLICK_NEWPM"))) {
                        break;
                    }
                } while (!Util.isLoginedUser(getApplicationContext(), (TapatalkForum) localObject1));
                if ((((TapatalkForum) localObject1).isPMEnable()) && (!((TapatalkForum) localObject1).isSupportConve())) {
                    paramIntent = new Intent(this, SlidingMenuActivity.class);
                    paramIntent.putExtra("defaultclick", 1021);
                    paramIntent.putExtra("writePm", true);
                    paramIntent.putExtra("fromWidget", true);
                }
                for (; ; ) {
                    paramIntent.putExtra("forum", (Serializable) localObject1);
                    paramIntent.putExtra("forumId", ((TapatalkForum) localObject1).getId());
                    paramIntent.addFlags(268435456);
                    startActivity(paramIntent);
                    return;
                    paramIntent = new Intent(this, SlidingMenuActivity.class);
                    paramIntent.putExtra("defaultclick", 1020);
                    paramIntent.putExtra("writeConversation", true);
                    paramIntent.putExtra("fromWidget", true);
                }
            }
            while ((paramIntent == null) || (paramIntent.getAction() == null) || (!paramIntent.getAction().equals("android.appwidget.action.TOPIC_REFERESH")));
            paramInt = paramIntent.getIntExtra("widgetId", -1);
        }
        while ((!Util.isLoginedUser(getApplicationContext(), (TapatalkForum) localObject1)) || (!Util.isConn(this)) || (paramInt == -1));
        FavTopicsWidgetManager.getInstance().getOrCreateWidget(this, paramInt).refresh();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/tabwidget/WidgetClickHandlerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */