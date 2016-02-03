package com.appflood.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.appflood.AFFullScreenActivity;
import com.appflood.AFInterstitialActivity;
import com.appflood.AFListActivity;
import com.appflood.AFListActivity.1;
import com.appflood.AFPanelActivity;
import com.appflood.AppFlood.AFEventDelegate;
import com.appflood.AppFlood.AFRequestDelegate;
import com.appflood.b.b;
import com.appflood.b.b.a;
import com.appflood.e.c;
import com.appflood.e.j;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  private static e c;
  public AppFlood.AFEventDelegate a = null;
  public boolean b = false;
  
  public static e a()
  {
    if (c == null) {
      c = new e();
    }
    return c;
  }
  
  public static void a(AppFlood.AFRequestDelegate paramAFRequestDelegate, boolean paramBoolean, JSONArray paramJSONArray)
  {
    try
    {
      paramAFRequestDelegate.onFinish(j.a("success", Boolean.valueOf(paramBoolean)).put("data", paramJSONArray));
      return;
    }
    catch (Throwable paramAFRequestDelegate) {}
  }
  
  public final void a(Activity paramActivity)
  {
    if (!this.b)
    {
      j.c("AppFlood not initialized");
      return;
    }
    if (paramActivity == null)
    {
      j.c("activity is null");
      return;
    }
    d.a(paramActivity, new d.a()
    {
      public final void a()
      {
        Intent localIntent = new Intent(e.this, AFFullScreenActivity.class);
        localIntent.putExtra("isFull", AFListActivity.1.a(e.this));
        localIntent.putExtra("isPortrait", AFListActivity.1.b(e.this));
        localIntent.putExtra("titlebar", AFListActivity.1.c(e.this));
        AFListActivity.1.a(e.this, localIntent);
      }
    });
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (!this.b)
        {
          d.F = paramInt1;
          j.d("Papaya AppFlood SDK init version V2.22");
        }
        try
        {
          c.a(paramContext);
          if (paramInt2 != 0) {
            continue;
          }
          d.a(bool);
          if (!d.a) {
            continue;
          }
          d.D = paramString3;
          if (!d.a) {
            continue;
          }
          d.E = paramString4;
          f.a(paramContext, true);
          f.a();
        }
        catch (Throwable paramContext)
        {
          j.a(paramContext, "initialize failed");
          continue;
        }
        this.b = true;
        return;
      }
      finally {}
      if (paramInt2 == 1)
      {
        bool = false;
      }
      else
      {
        bool = c.a();
        continue;
        paramString3 = paramString1;
        continue;
        paramString4 = paramString2;
      }
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    if (this.a != null) {
      this.a.onFinish(paramBoolean, paramInt);
    }
  }
  
  public final void a(final boolean paramBoolean, final JSONObject paramJSONObject)
  {
    if (this.a != null) {
      f.a(new TimerTask()
      {
        public final void run()
        {
          try
          {
            if (paramBoolean)
            {
              e.this.a.onClick(paramJSONObject);
              return;
            }
            e.this.a.onClose(paramJSONObject);
            return;
          }
          catch (Throwable localThrowable) {}
        }
      }, 0L);
    }
  }
  
  public final void b()
  {
    try
    {
      if (this.b)
      {
        j.a();
        this.a = null;
        f.f();
        this.b = false;
        d.j = false;
        d.D = null;
        d.E = null;
        d.k = null;
        d.m = null;
        d.n = null;
        d.t = null;
        d.u = null;
        d.v = null;
        d.B = 30000;
        d.y = null;
        d.o = null;
        d.p = null;
        d.q = null;
        d.r = null;
        d.H = true;
        d.G = 0;
        c.y = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */