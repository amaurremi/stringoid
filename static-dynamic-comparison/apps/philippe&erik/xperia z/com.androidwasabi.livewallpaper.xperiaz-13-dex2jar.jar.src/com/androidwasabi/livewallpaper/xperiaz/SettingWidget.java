package com.androidwasabi.livewallpaper.xperiaz;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class SettingWidget
  extends AppWidgetProvider
{
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130903055);
    int i = paramArrayOfInt[0];
    Intent localIntent = new Intent(paramContext, Settings.class);
    localIntent.putExtra("appWidgetId", i);
    localRemoteViews.setOnClickPendingIntent(2131296282, PendingIntent.getActivity(paramContext, i, localIntent, 0));
    paramAppWidgetManager.updateAppWidget(paramArrayOfInt, localRemoteViews);
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/SettingWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */