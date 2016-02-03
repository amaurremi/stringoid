package com.gau.go.launcherex.gowidget.billing;

import android.content.AsyncQueryHandler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import java.util.ArrayList;
import java.util.Iterator;

public class WidgetBillingChangeBroadcaster
  extends BroadcastReceiver
{
  private Context a;
  private ArrayList b = new ArrayList();
  private AsyncQueryHandler c;
  private boolean d;
  
  public WidgetBillingChangeBroadcaster(Context paramContext)
  {
    this.a = paramContext;
    paramContext = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
    this.a.registerReceiver(this, paramContext);
    this.c = new w(this, this.a.getContentResolver());
  }
  
  private void a(Cursor paramCursor)
  {
    boolean bool = true;
    if (paramCursor != null)
    {
      paramCursor.moveToFirst();
      if (paramCursor.getInt(0) == 1) {}
      while ((this.d != bool) && (!this.b.isEmpty()))
      {
        this.d = bool;
        paramCursor = this.b.iterator();
        while (paramCursor.hasNext()) {
          ((x)paramCursor.next()).a(this.d);
        }
        bool = false;
      }
    }
  }
  
  public void a(x paramx)
  {
    this.b.add(paramx);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.c.startQuery(0, null, WeatherContentProvider.j, null, null, null, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/WidgetBillingChangeBroadcaster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */