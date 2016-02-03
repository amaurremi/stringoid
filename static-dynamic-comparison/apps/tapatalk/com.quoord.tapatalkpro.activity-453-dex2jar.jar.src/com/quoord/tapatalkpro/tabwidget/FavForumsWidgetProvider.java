package com.quoord.tapatalkpro.tabwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViewsService;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.quoord.tapatalkpro.tabwidget.manager.FavForumWidgetManager;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FavForumsWidgetProvider
        extends AppWidgetProvider {
    public static final String ACTION_FORUM_APPWIDGET_UPDATE = "android.appwidget.action.APPWIDGET_UPDATE";
    public static final String ACTION_FORUM_CLICK = "android.appwidget.action.FORUM_CLICK";
    public static final String ACTION_FORUM_REFERESH = "android.appwidget.action.FORUM_REFERESH";

    public void onDeleted(Context paramContext, int[] paramArrayOfInt) {
        FavForumWidgetManager.getInstance().deleteWidgets(paramContext, paramArrayOfInt);
        super.onDeleted(paramContext, paramArrayOfInt);
    }

    public void onDisabled(Context paramContext) {
        super.onDisabled(paramContext);
    }

    public void onEnabled(Context paramContext) {
        super.onEnabled(paramContext);
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        try {
            String str = paramIntent.getAction();
            if ("android.appwidget.action.APPWIDGET_UPDATE".equals(str)) {
                paramIntent = AppWidgetManager.getInstance(paramContext);
                paramIntent.notifyAppWidgetViewDataChanged(paramIntent.getAppWidgetIds(new ComponentName(paramContext, FavForumsWidgetProvider.class)), 2131230759);
                return;
            }
            if ("android.appwidget.action.APPWIDGET_DELETED".equals(str)) {
                paramIntent = paramIntent.getIntArrayExtra("widgetIds");
                FavForumWidgetManager.getInstance().deleteWidgets(paramContext, paramIntent);
                return;
            }
            super.onReceive(paramContext, paramIntent);
            return;
        } catch (Exception paramContext) {
        }
    }

    public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt) {
        super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
        FavForumWidgetManager.getInstance().updateWidgets(paramContext, paramArrayOfInt);
    }

    public static class FavForumListViewService
            extends RemoteViewsService {
        protected void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
            FavForumWidgetManager.getInstance().dump(paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }

        public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent paramIntent) {
            int i = paramIntent.getIntExtra("appWidgetId", -1);
            return FavForumWidgetManager.getInstance().getOrCreateWidget(this, i);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/tabwidget/FavForumsWidgetProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */