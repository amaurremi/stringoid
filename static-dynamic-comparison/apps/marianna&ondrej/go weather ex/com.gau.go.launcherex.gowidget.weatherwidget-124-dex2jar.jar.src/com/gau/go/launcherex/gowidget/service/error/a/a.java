package com.gau.go.launcherex.gowidget.service.error.a;

import android.content.Context;
import android.text.format.Time;
import com.gau.go.launcherex.gowidget.service.error.model.LocationErrorBean;

public class a
{
  private Context a;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private String a()
  {
    Time localTime = new Time("Asia/Shanghai");
    localTime.setToNow();
    return localTime.format("%Y/%m/%d");
  }
  
  public void a(LocationErrorBean paramLocationErrorBean)
  {
    new b(this).execute(new LocationErrorBean[] { paramLocationErrorBean });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/service/error/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */