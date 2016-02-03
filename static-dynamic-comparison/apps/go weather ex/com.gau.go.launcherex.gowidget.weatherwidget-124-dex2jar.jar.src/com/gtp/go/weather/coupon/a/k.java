package com.gtp.go.weather.coupon.a;

import android.os.AsyncTask;
import com.gtp.go.weather.coupon.b.b;
import java.util.ArrayList;
import java.util.Iterator;

class k
  extends AsyncTask
{
  private k(e parame) {}
  
  protected ArrayList a(Object... paramVarArgs)
  {
    paramVarArgs = e.a(e.a(this.a), new String[] { "coupon_id", "source_coupon_id", "title", "desc", "coupon_type", "exp_time", "code", "logo_url", "logo_path", "shop_name" }, null, null);
    Object localObject = a.a(e.a(this.a), new String[] { "coupon_id" }, null, null);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramVarArgs.iterator();
    while (localIterator1.hasNext())
    {
      b localb1 = (b)localIterator1.next();
      Iterator localIterator2 = ((ArrayList)localObject).iterator();
      while (localIterator2.hasNext())
      {
        b localb2 = (b)localIterator2.next();
        if (localb1.b() == localb2.b()) {
          localb1.c(true);
        }
      }
      if (com.gtp.go.weather.coupon.c.a.c(localb1.g())) {
        localArrayList.add(localb1);
      }
    }
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramVarArgs.remove((b)((Iterator)localObject).next());
    }
    return paramVarArgs;
  }
  
  protected void a(ArrayList paramArrayList)
  {
    super.onPostExecute(paramArrayList);
    if (e.b(this.a) != null) {
      e.b(this.a).a(paramArrayList);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */