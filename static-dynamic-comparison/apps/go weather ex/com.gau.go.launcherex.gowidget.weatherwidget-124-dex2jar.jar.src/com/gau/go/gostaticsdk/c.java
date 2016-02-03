package com.gau.go.gostaticsdk;

import android.content.Context;
import com.gau.go.gostaticsdk.f.d;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

class c
  extends Thread
{
  c(b paramb, String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  public void run()
  {
    try
    {
      String str = b.c() + b.a(this.b).getPackageName() + b.b(this.b);
      Object localObject = b.a(this.b, str);
      localObject = b.a(this.b, (JSONObject)localObject);
      if (localObject != null)
      {
        Iterator localIterator = ((ArrayList)localObject).iterator();
        while (localIterator.hasNext())
        {
          com.gau.go.gostaticsdk.a.b localb = (com.gau.go.gostaticsdk.a.b)localIterator.next();
          if ((localb.d != null) && (localb.d.equals(this.a)))
          {
            localb.f = System.currentTimeMillis();
            d.a("StatisticsManager", "find " + this.a + " in record");
            if (localb.f - localb.e > 3600000L) {
              localIterator.remove();
            }
            b.a(this.b, str, (ArrayList)localObject);
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */