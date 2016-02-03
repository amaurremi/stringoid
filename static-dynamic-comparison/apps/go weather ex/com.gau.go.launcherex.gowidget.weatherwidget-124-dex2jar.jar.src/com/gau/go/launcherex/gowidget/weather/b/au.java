package com.gau.go.launcherex.gowidget.weather.b;

import android.content.ContentProviderResult;
import android.content.Context;
import com.jiubang.core.c.j;
import java.lang.ref.WeakReference;
import java.util.List;

class au
  extends j
{
  private WeakReference a;
  
  public au(at paramat)
  {
    super(at.b(paramat).getContentResolver());
    this.a = new WeakReference(paramat);
  }
  
  protected void a(int paramInt, Object paramObject, ContentProviderResult[] paramArrayOfContentProviderResult)
  {
    paramArrayOfContentProviderResult = (at)this.a.get();
    if (paramArrayOfContentProviderResult == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    at.a(paramArrayOfContentProviderResult, (List)paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */