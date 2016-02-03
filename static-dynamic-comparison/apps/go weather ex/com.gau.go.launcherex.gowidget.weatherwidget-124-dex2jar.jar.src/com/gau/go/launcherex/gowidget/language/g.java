package com.gau.go.launcherex.gowidget.language;

import android.annotation.SuppressLint;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.database.Cursor;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.jiubang.core.c.j;

@SuppressLint({"HandlerLeak"})
class g
  extends j
{
  public g(d paramd, ContentResolver paramContentResolver)
  {
    super(paramContentResolver);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    super.a(paramInt, paramObject, paramCursor);
    paramObject = (i)paramObject;
    d.a(this.a, paramCursor);
    d.d(this.a);
    ((i)paramObject).e();
  }
  
  protected void a(int paramInt, Object paramObject, ContentProviderResult[] paramArrayOfContentProviderResult)
  {
    super.a(paramInt, paramObject, paramArrayOfContentProviderResult);
    switch (paramInt)
    {
    default: 
      return;
    }
    d.e(this.a);
    f.a(d.a(this.a)).i();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/language/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */