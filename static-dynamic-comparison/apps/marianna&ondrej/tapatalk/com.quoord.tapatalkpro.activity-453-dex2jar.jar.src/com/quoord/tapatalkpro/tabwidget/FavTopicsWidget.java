package com.quoord.tapatalkpro.tabwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction.ActionCallBack;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.bean.TopicParser;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.tabwidget.manager.FavTopicsWidgetManager;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FavTopicsWidget
        implements RemoteViewsService.RemoteViewsFactory {
    private static Context mContext = null;
    private int forumId;
    public List<Object> mList = new ArrayList();
    private final int mWidgetId;
    private final AppWidgetManager mWidgetManager;
    private GetTopicTask myTimeTask;
    private TapatalkForum tapatalkForum;
    private Timer timer;

    public FavTopicsWidget(Context paramContext, int paramInt1, int paramInt2) {
        mContext = paramContext;
        this.mWidgetManager = AppWidgetManager.getInstance(mContext);
        this.mWidgetId = paramInt1;
        this.forumId = paramInt2;
        this.tapatalkForum = getTapatalkForum(this.forumId);
        updateWidgetView();
    }

    private TapatalkForum getTapatalkForum(String paramString) {
        Object localObject1 = null;
        Object localObject2 = new FavoriateSqlHelper(mContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        if (!mContext.getResources().getBoolean(2131558401)) {
            localObject1 = ((FavoriateSqlHelper) localObject2).getFavrivateById(paramString);
            return (TapatalkForum) localObject1;
        }
        localObject2 = ((FavoriateSqlHelper) localObject2).getFavrivate();
        int i = 0;
        for (paramString = (String) localObject1; ; paramString = (String) localObject1) {
            localObject1 = paramString;
            if (i >= ((ArrayList) localObject2).size()) {
                break;
            }
            localObject1 = paramString;
            if (((TapatalkForum) ((ArrayList) localObject2).get(i)).getUserName() != null) {
                localObject1 = paramString;
                if (((TapatalkForum) ((ArrayList) localObject2).get(i)).getUserName().length() > 0) {
                    localObject1 = paramString;
                    if (((TapatalkForum) ((ArrayList) localObject2).get(i)).hasPassword()) {
                        localObject1 = (TapatalkForum) ((ArrayList) localObject2).get(i);
                    }
                }
            }
            i += 1;
        }
    }

    public int getCount() {
        return this.mList.size();
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public RemoteViews getLoadingView() {
        return new RemoteViews(mContext.getPackageName(), 2130903080);
    }

    public RemoteViews getNoLoginView() {
        RemoteViews localRemoteViews = new RemoteViews(mContext.getPackageName(), 2130903295);
        localRemoteViews.setTextViewText(2131230763, "No Login");
        Intent localIntent = new Intent(mContext, WidgetClickHandlerService.class).setFlags(67108864);
        localIntent.setAction("android.appwidget.action.CLICK_LOGIN");
        localRemoteViews.setOnClickFillInIntent(2131230762, localIntent);
        return localRemoteViews;
    }

    public RemoteViews getNoneView() {
        return new RemoteViews(mContext.getPackageName(), 2130903295);
    }

    public RemoteViews getViewAt(int paramInt) {
        if ((paramInt < this.mList.size()) && ((this.mList.get(paramInt) instanceof Topic))) {
            RemoteViews localRemoteViews = new RemoteViews(mContext.getPackageName(), 2130903441);
            Topic localTopic = (Topic) this.mList.get(paramInt);
            for (; ; ) {
                try {
                    localRemoteViews.setTextViewText(2131230769, localTopic.getTitle());
                    if ((localTopic.getTitle() != null) && (localTopic.getTitle().length() > 0) && (!localTopic.getNewPost())) {
                        paramInt = localTopic.getTitle().length();
                        localObject = new SpannableString(localTopic.getTitle());
                        ((SpannableString) localObject).setSpan(new ForegroundColorSpan(mContext.getResources().getColor(2131165283)), 0, paramInt, 0);
                        localRemoteViews.setTextViewText(2131230769, (CharSequence) localObject);
                    }
                    localRemoteViews.setTextViewText(2131230778, localTopic.getShortContent());
                    if ((localTopic.getAuthorName() == null) && (localTopic.getAuthorDisplayName() == null)) {
                        continue;
                    }
                    if (localTopic.getAuthorDisplayName() == null) {
                        continue;
                    }
                    localObject = localTopic.getAuthorDisplayName();
                    localRemoteViews.setTextViewText(2131231190, (CharSequence) localObject);
                    localRemoteViews.setTextViewText(2131231748, Util.formatDateInThread(localTopic.getLastReplyTime(), mContext));
                } catch (Exception localException) {
                    Object localObject;
                    Bundle localBundle;
                    localException.printStackTrace();
                    continue;
                }
                localObject = new Intent(mContext, WidgetClickHandlerService.class).setFlags(67108864);
                ((Intent) localObject).setAction("android.appwidget.action.FAV_TOPIC_CLICK");
                localBundle = new Bundle();
                localBundle.putSerializable("serial", localTopic);
                ((Intent) localObject).putExtra("forumId", FavTopicsWidgetManager.loadForumIdPref(mContext, this.mWidgetId));
                ((Intent) localObject).putExtra("widgetId", this.mWidgetId);
                ((Intent) localObject).putExtras(localBundle);
                localRemoteViews.setOnClickFillInIntent(2131231747, (Intent) localObject);
                return localRemoteViews;
                localObject = localTopic.getAuthorName();
                continue;
                if (localTopic.getLastPosterDisplayName() != null) {
                    localObject = localTopic.getLastPosterDisplayName();
                } else {
                    localObject = localTopic.getLastPosterName();
                }
            }
        }
        if (paramInt < this.mList.size()) {
            String str = (String) this.mList.get(paramInt);
            if (str.equals("load")) {
                return getLoadingView();
            }
            if (str.equals("nologin")) {
                return getNoLoginView();
            }
            return getNoneView();
        }
        return getNoneView();
    }

    public int getViewTypeCount() {
        return 4;
    }

    public boolean hasStableIds() {
        return true;
    }

    public void onCreate() {
        this.mList.add("load");
    }

    public void onDataSetChanged() {
    }

    public void onDeleted() {
        stopTimer();
    }

    public void onDestroy() {
        this.mList.clear();
    }

    public void refresh() {
        RemoteViews localRemoteViews = new RemoteViews(mContext.getPackageName(), 2130903440);
        localRemoteViews.setViewVisibility(2131231746, 8);
        localRemoteViews.setViewVisibility(2131230844, 0);
        this.mWidgetManager.updateAppWidget(this.mWidgetId, localRemoteViews);
        new Timer().schedule(new GetTopicTask(mContext, this.mWidgetId, this.tapatalkForum), 1000L);
    }

    public void reset() {
        start();
    }

    public void start() {
        this.timer = new Timer();
        this.myTimeTask = new GetTopicTask(mContext, this.mWidgetId, this.tapatalkForum);
        this.timer.scheduleAtFixedRate(this.myTimeTask, 1000L, 1800000L);
    }

    public void stopTimer() {
        if (this.timer != null) {
            this.timer.cancel();
            this.timer.purge();
        }
        if (this.myTimeTask != null) {
            this.myTimeTask.cancel();
        }
    }

    public void updateWidgetView() {
        Intent localIntent = new Intent(mContext, FavTopicsWidgetProvider.FavTopicsListViewService.class);
        localIntent.putExtra("appWidgetId", this.mWidgetId);
        localIntent.setData(Uri.parse(localIntent.toUri(1)));
        RemoteViews localRemoteViews = new RemoteViews(mContext.getPackageName(), 2130903440);
        if (this.tapatalkForum != null) {
            localRemoteViews.setTextViewText(2131231178, this.tapatalkForum.getName());
        }
        localRemoteViews.setViewVisibility(2131231746, 0);
        localRemoteViews.setViewVisibility(2131230844, 8);
        localRemoteViews.setRemoteAdapter(this.mWidgetId, 2131230759, localIntent);
        this.mWidgetManager.notifyAppWidgetViewDataChanged(this.mWidgetId, 2131230759);
        localIntent = new Intent(mContext, WidgetClickHandlerService.class);
        localRemoteViews.setPendingIntentTemplate(2131230759, PendingIntent.getService(mContext, 0, localIntent, 134217728));
        localIntent = new Intent(mContext, WidgetClickHandlerService.class);
        localIntent.setAction("android.appwidget.action.TOPIC_REFERESH");
        localIntent.putExtra("widgetId", this.mWidgetId);
        localRemoteViews.setOnClickPendingIntent(2131231746, PendingIntent.getService(mContext, this.mWidgetId, localIntent, 134217728));
        this.mWidgetManager.updateAppWidget(this.mWidgetId, localRemoteViews);
    }

    public class GetTopicTask
            extends TimerTask
            implements TryTwiceCallBackInterface {
        Context context;
        TapatalkEngine engine;
        TapatalkForum forum;
        int forumId;
        ForumLoginOrSignAction loginOrSign;
        RemoteViews remoteViews;
        ForumStatus status;
        int widgetId;

        public GetTopicTask(Context paramContext, int paramInt, TapatalkForum paramTapatalkForum) {
            this.context = paramContext;
            this.widgetId = paramInt;
            this.forumId = FavTopicsWidgetManager.loadForumIdPref(this.context, paramInt);
            this.forum = paramTapatalkForum;
            this.status = ForumStatus.initialForumStatus(this.context, this.forum, null, null);
            this.loginOrSign = new ForumLoginOrSignAction(this.context, this.status);
        }

        public void callBack(EngineResponse paramEngineResponse) {
            if (paramEngineResponse.getMethod().equals("get_subscribed_topic")) {
                paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
                if ((!paramEngineResponse.containsKey("result")) || (((Boolean) paramEngineResponse.get("result")).booleanValue())) {
                }
            } else {
                return;
            }
            paramEngineResponse = (Object[]) paramEngineResponse.get("topics");
            FavTopicsWidget.this.mList.clear();
            if ((paramEngineResponse == null) || (paramEngineResponse.length == 0)) {
                FavTopicsWidget.this.mList.add("notopic");
            }
            for (; ; ) {
                FavTopicsWidget.this.updateWidgetView();
                return;
                int i = 0;
                while ((i < paramEngineResponse.length) && (i < 10)) {
                    Topic localTopic = TopicParser.createTopicBean((HashMap) paramEngineResponse[i], this.forum.getName(), FavTopicsWidget.mContext, this.status);
                    FavTopicsWidget.this.mList.add(localTopic);
                    i += 1;
                }
            }
        }

        public boolean getSaxCall() {
            return false;
        }

        public boolean getTryTwice() {
            return false;
        }

        public boolean isOpCancel() {
            return false;
        }

        public void run() {
            try {
                if (Util.isLoginedUser(this.context, this.forum)) {
                    this.status = ForumStatus.initialForumStatus(this.context, this.forum, null, null, true);
                    if (!Util.isConn(FavTopicsWidget.mContext)) {
                        return;
                    }
                    this.engine = new TapatalkEngine(this, this.status, this.context);
                    if (Util.isSignedUser(this.context, this.forum)) {
                        this.loginOrSign.signForum(this.forum.getUserNameOrDisplayName(), null, false, false, false, new ForumLoginOrSignAction.ActionCallBack() {
                            public void actionErrorBack(String paramAnonymousString1, String paramAnonymousString2) {
                            }

                            public void actionSuccessBack(ForumStatus paramAnonymousForumStatus) {
                                paramAnonymousForumStatus = new ArrayList();
                                FavTopicsWidget.GetTopicTask.this.engine.call("get_subscribed_topic", paramAnonymousForumStatus);
                            }
                        });
                        return;
                    }
                    if ((this.forum.getPassword() == null) || (this.forum.getPassword().equals(""))) {
                        return;
                    }
                    this.loginOrSign.loginForum(this.forum.getUserNameOrDisplayName(), this.forum.getPassword(), false, false, false, new ForumLoginOrSignAction.ActionCallBack() {
                        public void actionErrorBack(String paramAnonymousString1, String paramAnonymousString2) {
                        }

                        public void actionSuccessBack(ForumStatus paramAnonymousForumStatus) {
                            paramAnonymousForumStatus = new ArrayList();
                            FavTopicsWidget.GetTopicTask.this.engine.call("get_subscribed_topic", paramAnonymousForumStatus);
                        }
                    });
                    return;
                }
            } catch (Exception localException) {
                localException.printStackTrace();
                return;
            }
            FavTopicsWidget.this.mList.clear();
            FavTopicsWidget.this.mList.add("nologin");
            FavTopicsWidget.this.mWidgetManager.notifyAppWidgetViewDataChanged(this.widgetId, 2131230759);
        }

        public void setOpCancel(boolean paramBoolean) {
        }

        public void setSaxCall(boolean paramBoolean) {
        }

        public void setTryTwice(boolean paramBoolean) {
        }

        public void tryFailed(String paramString) {
        }

        public void updateSubclassDialog(int paramInt) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/tabwidget/FavTopicsWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */