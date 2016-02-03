package com.gtp.go.weather.sharephoto.award;

import android.content.Context;
import android.os.AsyncTask;
import com.gtp.go.weather.sharephoto.b.d;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class q
  extends AsyncTask
{
  private WeakReference a;
  private Context b;
  
  q(k paramk)
  {
    this.b = k.d(paramk);
    this.a = new WeakReference(paramk);
  }
  
  protected List a(List... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    Iterator localIterator = paramVarArgs.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if ((locald.j() == 1) || (locald.j() == 2))
      {
        long l1 = locald.h();
        long l2 = locald.a();
        List localList = com.gtp.go.weather.sharephoto.b.a.b.a(this.b, null, "award_id=? and user_award_id=?", new String[] { String.valueOf(l1), String.valueOf(l2) });
        if (localList.size() > 0) {
          locald.a((com.gtp.go.weather.sharephoto.b.b)localList.get(0));
        }
      }
    }
    return paramVarArgs;
  }
  
  protected void a(List paramList)
  {
    k localk = (k)this.a.get();
    if (localk == null) {
      return;
    }
    k.c(localk, paramList);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */