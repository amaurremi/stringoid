package com.gau.go.launcherex.gowidget.billing;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;

class w
  extends AsyncQueryHandler
{
  w(WidgetBillingChangeBroadcaster paramWidgetBillingChangeBroadcaster, ContentResolver paramContentResolver)
  {
    super(paramContentResolver);
  }
  
  protected void onQueryComplete(int paramInt, Object paramObject, Cursor paramCursor)
  {
    WidgetBillingChangeBroadcaster.a(this.a, paramCursor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */