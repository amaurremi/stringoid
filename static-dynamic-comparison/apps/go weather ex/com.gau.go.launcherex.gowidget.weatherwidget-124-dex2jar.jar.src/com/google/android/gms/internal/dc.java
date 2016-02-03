package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class dc
  extends db.a
{
  private static final Object px = new Object();
  private static dc py;
  private final Context mContext;
  private final ax pA;
  private final bf pz;
  
  private dc(Context paramContext, ax paramax, bf parambf)
  {
    this.mContext = paramContext;
    this.pz = parambf;
    this.pA = paramax;
  }
  
  private static cz a(Context paramContext, final ax paramax, final bf parambf, final cx paramcx)
  {
    dw.v("Starting ad request from service.");
    parambf.init();
    dg localdg = new dg(paramContext);
    if (localdg.qk == -1)
    {
      dw.v("Device is offline.");
      return new cz(2);
    }
    final de localde = new de(paramcx.applicationInfo.packageName);
    if (paramcx.pg.extras != null)
    {
      localObject = paramcx.pg.extras.getString("_ad");
      if (localObject != null) {
        return dd.a(paramContext, paramcx, (String)localObject);
      }
    }
    Object localObject = parambf.a(250L);
    parambf = paramax.aH();
    paramax = dd.a(paramcx, localdg, (Location)localObject, paramax.aI());
    if (paramax == null) {
      return new cz(0);
    }
    paramax = p(paramax);
    dv.rp.post(new Runnable()
    {
      public void run()
      {
        dz localdz = dz.a(this.pB, new ak(), false, false, null, paramcx.kK);
        localdz.setWillNotDraw(true);
        localde.b(localdz);
        ea localea = localdz.bI();
        localea.a("/invalidRequest", localde.pK);
        localea.a("/loadAdURL", localde.pL);
        localea.a("/log", ba.mM);
        localea.a(paramax);
        dw.v("Loading the JS library.");
        localdz.loadUrl(parambf);
      }
    });
    paramax = localde.bj();
    if (TextUtils.isEmpty(paramax)) {
      return new cz(localde.getErrorCode());
    }
    return a(paramContext, paramcx.kK.rq, paramax);
  }
  
  public static cz a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      localdf = new df();
      paramString2 = new URL(paramString2);
      l = SystemClock.elapsedRealtime();
      i = 0;
    }
    catch (IOException paramContext)
    {
      try
      {
        for (;;)
        {
          df localdf;
          long l;
          int i;
          dq.a(paramContext, paramString1, false, localHttpURLConnection);
          int j = localHttpURLConnection.getResponseCode();
          Map localMap = localHttpURLConnection.getHeaderFields();
          if ((j >= 200) && (j < 300))
          {
            paramContext = paramString2.toString();
            paramString1 = dq.a(new InputStreamReader(localHttpURLConnection.getInputStream()));
            a(paramContext, localMap, paramString1, j);
            localdf.a(paramContext, localMap, paramString1);
            paramContext = localdf.g(l);
            return paramContext;
          }
          a(paramString2.toString(), localMap, null, j);
          if ((j >= 300) && (j < 400))
          {
            paramString2 = localHttpURLConnection.getHeaderField("Location");
            if (TextUtils.isEmpty(paramString2))
            {
              dw.z("No location header to follow redirect.");
              paramContext = new cz(0);
              return paramContext;
            }
            paramString2 = new URL(paramString2);
            i += 1;
            if (i > 5)
            {
              dw.z("Too many redirects.");
              paramContext = new cz(0);
              return paramContext;
            }
          }
          else
          {
            dw.z("Received error HTTP response code: " + j);
            paramContext = new cz(0);
            return paramContext;
          }
          localdf.e(localMap);
          localHttpURLConnection.disconnect();
        }
      }
      finally
      {
        HttpURLConnection localHttpURLConnection;
        localHttpURLConnection.disconnect();
      }
      paramContext = paramContext;
      dw.z("Error while connecting to ad server: " + paramContext.getMessage());
      return new cz(2);
    }
    localHttpURLConnection = (HttpURLConnection)paramString2.openConnection();
  }
  
  public static dc a(Context paramContext, ax paramax, bf parambf)
  {
    synchronized (px)
    {
      if (py == null) {
        py = new dc(paramContext.getApplicationContext(), paramax, parambf);
      }
      paramContext = py;
      return paramContext;
    }
  }
  
  private static void a(String paramString1, Map<String, List<String>> paramMap, String paramString2, int paramInt)
  {
    if (dw.n(2))
    {
      dw.y("Http Response: {\n  URL:\n    " + paramString1 + "\n  Headers:");
      if (paramMap != null)
      {
        paramString1 = paramMap.keySet().iterator();
        while (paramString1.hasNext())
        {
          Object localObject = (String)paramString1.next();
          dw.y("    " + (String)localObject + ":");
          localObject = ((List)paramMap.get(localObject)).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            dw.y("      " + str);
          }
        }
      }
      dw.y("  Body:");
      if (paramString2 != null)
      {
        int i = 0;
        while (i < Math.min(paramString2.length(), 100000))
        {
          dw.y(paramString2.substring(i, Math.min(paramString2.length(), i + 1000)));
          i += 1000;
        }
      }
      dw.y("    null");
      dw.y("  Response Code:\n    " + paramInt + "\n}");
    }
  }
  
  private static ea.a p(String paramString)
  {
    new ea.a()
    {
      public void a(dz paramAnonymousdz)
      {
        String str = String.format("javascript:%s(%s);", new Object[] { "AFMA_buildAdURL", this.pG });
        dw.y("About to execute: " + str);
        paramAnonymousdz.loadUrl(str);
      }
    };
  }
  
  public cz b(cx paramcx)
  {
    return a(this.mContext, this.pA, this.pz, paramcx);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */