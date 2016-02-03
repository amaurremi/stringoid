package com.quoord.tapatalkpro.tabwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.sqlhelper.SubscribeForumSqlHelper;
import com.quoord.tapatalkpro.tabwidget.manager.FavForumWidgetManager;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FavForumWidget
        implements RemoteViewsService.RemoteViewsFactory {
    private static Context mContext = null;
    private int forumId;
    public List<Object> mList = new ArrayList();
    private final int mWidgetId;
    private final AppWidgetManager mWidgetManager;
    private MyTime myTimeTask;
    private TapatalkForum tapatalkForum;
    private Timer timer;

    public FavForumWidget(Context paramContext, int paramInt1, int paramInt2) {
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
        RemoteViews localRemoteViews = new RemoteViews(mContext.getPackageName(), 2130903295);
        localRemoteViews.setTextViewText(2131230763, "No Fav-Forums");
        return localRemoteViews;
    }

    public RemoteViews getViewAt(int paramInt) {
        if ((this.mList.get(paramInt) instanceof Forum)) {
            localObject = new RemoteViews(mContext.getPackageName(), 2130903439);
            Forum localForum = (Forum) this.mList.get(paramInt);
            ((RemoteViews) localObject).setTextViewText(2131230769, localForum.getName());
            Intent localIntent = new Intent(mContext, WidgetClickHandlerService.class).setFlags(67108864);
            localIntent.setAction("android.appwidget.action.FORUM_CLICK");
            Bundle localBundle = new Bundle();
            localBundle.putSerializable("forumserial", localForum);
            localIntent.putExtra("forumId", FavForumWidgetManager.loadForumIdPref(mContext, this.mWidgetId));
            localIntent.putExtra("defaultclick", 1019);
            localIntent.putExtras(localBundle);
            ((RemoteViews) localObject).setOnClickFillInIntent(2131231745, localIntent);
            return (RemoteViews) localObject;
        }
        Object localObject = (String) this.mList.get(paramInt);
        if (((String) localObject).equals("nologin")) {
            return getNoLoginView();
        }
        if (((String) localObject).equals("load")) {
            return getLoadingView();
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
    }

    public void onDataSetChanged() {
    }

    public void onDeleted() {
        stopTimer();
    }

    public void onDestroy() {
        this.mList.clear();
    }

    public void reset() {
        start();
    }

    public void start() {
        this.timer = new Timer();
        this.myTimeTask = new MyTime(mContext, this.mWidgetId, this.tapatalkForum);
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
        Intent localIntent = new Intent(mContext, FavForumsWidgetProvider.FavForumListViewService.class);
        localIntent.putExtra("appWidgetId", this.mWidgetId);
        localIntent.setData(Uri.parse(localIntent.toUri(1)));
        RemoteViews localRemoteViews = new RemoteViews(mContext.getPackageName(), 2130903438);
        localRemoteViews.setRemoteAdapter(this.mWidgetId, 2131230759, localIntent);
        this.mWidgetManager.notifyAppWidgetViewDataChanged(this.mWidgetId, 2131230759);
        localIntent = new Intent(mContext, WidgetClickHandlerService.class);
        localRemoteViews.setPendingIntentTemplate(2131230759, PendingIntent.getService(mContext, 0, localIntent, 134217728));
        if (this.tapatalkForum != null) {
            localRemoteViews.setTextViewText(2131231178, this.tapatalkForum.getName());
        }
        localIntent = new Intent(mContext, WidgetClickHandlerService.class);
        localIntent.setAction("android.appwidget.action.CLICK_LOGO");
        localRemoteViews.setOnClickPendingIntent(2131231605, PendingIntent.getService(mContext, 0, localIntent, 134217728));
        this.mWidgetManager.updateAppWidget(this.mWidgetId, localRemoteViews);
    }

    public class MyTime
            extends TimerTask {
        Context context;
        TapatalkEngine engine;
        TapatalkForum forum = null;
        int forumId;
        Handler handler;
        RemoteViews remoteViews;
        ForumStatus status;
        int widgetId;

        public MyTime(Context paramContext, int paramInt, TapatalkForum paramTapatalkForum) {
            this.context = paramContext;
            this.widgetId = paramInt;
            this.forumId = FavForumWidgetManager.loadForumIdPref(this.context, paramInt);
            this.forum = paramTapatalkForum;
            this.handler = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message paramAnonymousMessage) {
                    switch (paramAnonymousMessage.what) {
                        default:
                            return;
                    }
                    int i = ((Integer) paramAnonymousMessage.obj).intValue();
                    FavForumWidget.this.mWidgetManager.notifyAppWidgetViewDataChanged(i, 2131230759);
                }
            };
        }

        public void run() {
            Object localObject = new SubscribeForumSqlHelper(FavForumWidget.mContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
            if (FavForumWidget.this.tapatalkForum != null) {
                localObject = ((SubscribeForumSqlHelper) localObject).get(FavForumWidget.this.tapatalkForum.getUrl());
                if (FavForumWidget.this.mList.size() <= 0) {
                    FavForumWidget.this.mList.addAll((Collection) localObject);
                }
                if (FavForumWidget.this.mList.size() == 0) {
                    FavForumWidget.this.mList.add("notopic");
                }
                localObject = this.handler.obtainMessage();
                ((Message) localObject).what = 10001;
                ((Message) localObject).obj = Integer.valueOf(this.widgetId);
                this.handler.sendMessage((Message) localObject);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/tabwidget/FavForumWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */