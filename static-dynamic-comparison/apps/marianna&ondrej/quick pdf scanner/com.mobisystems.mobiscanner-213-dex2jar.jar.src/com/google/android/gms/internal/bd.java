package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
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

public final class bd
  extends bc.a
{
  private static final Object DS = new Object();
  private static bd DT;
  private final v DU;
  private final Context mContext;
  
  private bd(Context paramContext, v paramv)
  {
    this.mContext = paramContext;
    this.DU = paramv;
  }
  
  public static bd a(Context paramContext, v paramv)
  {
    synchronized (DS)
    {
      if (DT == null) {
        DT = new bd(paramContext.getApplicationContext(), paramv);
      }
      paramContext = DT;
      return paramContext;
    }
  }
  
  private static cf a(Context paramContext, final v paramv, final cd paramcd)
  {
    ce.aG("Starting ad request from service.");
    paramv.init();
    bh localbh = new bh(paramContext);
    if (localbh.Ez == -1)
    {
      ce.aG("Device is offline.");
      return new cf(2);
    }
    final bf localbf = new bf(paramcd.applicationInfo.packageName);
    if (paramcd.DB.extras != null)
    {
      String str = paramcd.DB.extras.getString("_ad");
      if (str != null) {
        return be.a(paramContext, paramcd, str);
      }
    }
    paramv = be.a(paramcd, localbh, paramv.e(250L));
    if (paramv == null) {
      return new cf(0);
    }
    cb.Fw.post(new Runnable()
    {
      public void run()
      {
        dd localdd = dd.a(this.uX, new ab(), false, false, null, paramcd.CY);
        localdd.setWillNotDraw(true);
        localbf.b(localdd);
        ch localch = localdd.pX();
        localch.a("/invalidRequest", localbf.Eb);
        localch.a("/loadAdURL", localbf.Ec);
        localch.a("/log", r.xP);
        ce.aG("Getting the ad request URL.");
        localdd.loadDataWithBaseURL("http://googleads.g.doubleclick.net", "<!DOCTYPE html><html><head><script src=\"http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.js\"></script><script>AFMA_buildAdURL(" + paramv + ");</script></head><body></body></html>", "text/html", "UTF-8", null);
      }
    });
    paramv = localbf.pC();
    if (TextUtils.isEmpty(paramv)) {
      return new cf(localbf.getErrorCode());
    }
    return b(paramContext, paramcd.CY.FK, paramv);
  }
  
  private static void a(String paramString1, Map<String, List<String>> paramMap, String paramString2, int paramInt)
  {
    if (ce.cB(2))
    {
      ce.C("Http Response: {\n  URL:\n    " + paramString1 + "\n  Headers:");
      if (paramMap != null)
      {
        paramString1 = paramMap.keySet().iterator();
        while (paramString1.hasNext())
        {
          Object localObject = (String)paramString1.next();
          ce.C("    " + (String)localObject + ":");
          localObject = ((List)paramMap.get(localObject)).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            ce.C("      " + str);
          }
        }
      }
      ce.C("  Body:");
      if (paramString2 != null)
      {
        int i = 0;
        while (i < Math.min(paramString2.length(), 100000))
        {
          ce.C(paramString2.substring(i, Math.min(paramString2.length(), i + 1000)));
          i += 1000;
        }
      }
      ce.C("    null");
      ce.C("  Response Code:\n    " + paramInt + "\n}");
    }
  }
  
  public static cf b(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      localbg = new bg();
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
          bg localbg;
          long l;
          int i;
          bw.a(paramContext, paramString1, false, localHttpURLConnection);
          int j = localHttpURLConnection.getResponseCode();
          Map localMap = localHttpURLConnection.getHeaderFields();
          if ((j >= 200) && (j < 300))
          {
            paramContext = paramString2.toString();
            paramString1 = bw.a(new InputStreamReader(localHttpURLConnection.getInputStream()));
            a(paramContext, localMap, paramString1, j);
            localbg.a(paramContext, localMap, paramString1);
            paramContext = localbg.j(l);
            return paramContext;
          }
          a(paramString2.toString(), localMap, null, j);
          if ((j >= 300) && (j < 400))
          {
            paramString2 = localHttpURLConnection.getHeaderField("Location");
            if (TextUtils.isEmpty(paramString2))
            {
              ce.D("No location header to follow redirect.");
              paramContext = new cf(0);
              return paramContext;
            }
            paramString2 = new URL(paramString2);
            i += 1;
            if (i > 5)
            {
              ce.D("Too many redirects.");
              paramContext = new cf(0);
              return paramContext;
            }
          }
          else
          {
            ce.D("Received error HTTP response code: " + j);
            paramContext = new cf(0);
            return paramContext;
          }
          localbg.s(localMap);
          localHttpURLConnection.disconnect();
        }
      }
      finally
      {
        HttpURLConnection localHttpURLConnection;
        localHttpURLConnection.disconnect();
      }
      paramContext = paramContext;
      ce.D("Error while connecting to ad server: " + paramContext.getMessage());
      return new cf(2);
    }
    localHttpURLConnection = (HttpURLConnection)paramString2.openConnection();
  }
  
  public cf b(cd paramcd)
  {
    return a(this.mContext, this.DU, paramcd);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */