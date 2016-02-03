package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.annotation.SuppressLint;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.text.format.Time;
import com.gau.go.launcherex.gowidget.messagecenter.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"HandlerLeak"})
class al
  extends AsyncQueryHandler
{
  public al(aj paramaj, ContentResolver paramContentResolver)
  {
    super(paramContentResolver);
  }
  
  private List a(Cursor paramCursor)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramCursor != null) && (paramCursor.getCount() != 0))
    {
      paramCursor.moveToFirst();
      int i = paramCursor.getColumnIndex("promo_code");
      int j = paramCursor.getColumnIndex("effective_time");
      int k = paramCursor.getColumnIndex("expired_time");
      if ((i != -1) && (j != -1) && (k != -1)) {
        do
        {
          f localf = new f();
          localf.a(paramCursor.getString(i));
          localf.a(paramCursor.getLong(j));
          localf.b(paramCursor.getLong(k));
          localArrayList.add(localf);
        } while (paramCursor.moveToNext());
      }
    }
    if ((paramCursor != null) && (!paramCursor.isClosed())) {}
    try
    {
      paramCursor.close();
      return localArrayList;
    }
    catch (Exception paramCursor)
    {
      paramCursor.printStackTrace();
    }
    return localArrayList;
  }
  
  private void a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      if (a(localf))
      {
        paramList.remove();
        localArrayList.add(localf);
      }
    }
  }
  
  public boolean a(f paramf)
  {
    boolean bool = false;
    Time localTime = new Time();
    localTime.setToNow();
    localTime.switchTimezone("GMT00:00");
    if (localTime.toMillis(false) > paramf.b()) {
      bool = true;
    }
    return bool;
  }
  
  protected void onQueryComplete(int paramInt, Object paramObject, Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      paramObject = (ak)paramObject;
      paramCursor = a(paramCursor);
      a(paramCursor);
      if (paramObject != null) {
        ((ak)paramObject).a(paramCursor);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */