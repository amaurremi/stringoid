package com.quoord.tapatalkpro.tabwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViewsService;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import android.widget.Toast;
import com.quoord.tapatalkpro.tabwidget.manager.FavTopicsWidgetManager;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FavTopicsWidgetProvider
        extends AppWidgetProvider {
    public static final String ACTION_BOOKMARK_APPWIDGET_UPDATE = "android.appwidget.action.APPWIDGET_UPDATE";
    public static final String ACTION_BOOKMARK_REFERESH = "android.appwidget.action.REFERESH";
    public static final String ACTION_FAV_TOPIC_CLICK = "android.appwidget.action.FAV_TOPIC_CLICK";

    public void onDeleted(Context paramContext, int[] paramArrayOfInt) {
        FavTopicsWidgetManager.getInstance().deleteWidgets(paramContext, paramArrayOfInt);
        super.onDeleted(paramContext, paramArrayOfInt);
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        try {
            if ("android.appwidget.action.APPWIDGET_UPDATE".equals(paramIntent.getAction())) {
                paramIntent = AppWidgetManager.getInstance(paramContext);
                paramIntent.notifyAppWidgetViewDataChanged(paramIntent.getAppWidgetIds(new ComponentName(paramContext, FavTopicsWidgetProvider.class)), 2131230759);
                return;
            }
            super.onReceive(paramContext, paramIntent);
            return;
        } catch (Exception paramIntent) {
            Toast.makeText(paramContext, paramIntent.toString(), 1).show();
        }
    }

    public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt) {
        super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
        FavTopicsWidgetManager.getInstance().updateWidgets(paramContext, paramArrayOfInt);
    }

    public static class FavTopicsListViewService
            extends RemoteViewsService {
        protected void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
            FavTopicsWidgetManager.getInstance().dump(paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }

        public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent paramIntent) {
            int i = paramIntent.getIntExtra("appWidgetId", -1);
            return FavTopicsWidgetManager.getInstance().getOrCreateWidget(this, i);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/tabwidget/FavTopicsWidgetProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */