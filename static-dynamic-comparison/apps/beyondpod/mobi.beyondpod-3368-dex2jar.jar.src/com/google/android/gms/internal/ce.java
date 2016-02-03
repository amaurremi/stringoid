package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ce
  extends cd.a
{
  private static final Object hC = new Object();
  private static ce hD;
  private final aq hE;
  private final Context mContext;
  
  private ce(Context paramContext, aq paramaq)
  {
    this.mContext = paramContext;
    this.hE = paramaq;
  }
  
  private static cb a(Context paramContext, final aq paramaq, final bz parambz)
  {
    ct.r("Starting ad request from service.");
    paramaq.init();
    ci localci = new ci(paramContext);
    if (localci.ik == -1)
    {
      ct.r("Device is offline.");
      return new cb(2);
    }
    final cg localcg = new cg(parambz.applicationInfo.packageName);
    if (parambz.hr.extras != null)
    {
      String str = parambz.hr.extras.getString("_ad");
      if (str != null) {
        return cf.a(paramContext, parambz, str);
      }
    }
    paramaq = cf.a(parambz, localci, paramaq.a(250L));
    if (paramaq == null) {
      return new cb(0);
    }
    cs.iI.post(new Runnable()
    {
      public void run()
      {
        cw localcw = cw.a(this.hF, new x(), false, false, null, parambz.ej);
        localcw.setWillNotDraw(true);
        localcg.b(localcw);
        cx localcx = localcw.aC();
        localcx.a("/invalidRequest", localcg.hM);
        localcx.a("/loadAdURL", localcg.hN);
        localcx.a("/log", am.fs);
        ct.r("Getting the ad request URL.");
        localcw.loadDataWithBaseURL("http://googleads.g.doubleclick.net", "<!DOCTYPE html><html><head><script src=\"http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.js\"></script><script>AFMA_buildAdURL(" + paramaq + ");</script></head><body></body></html>", "text/html", "UTF-8", null);
      }
    });
    paramaq = localcg.ap();
    if (TextUtils.isEmpty(paramaq)) {
      return new cb(localcg.getErrorCode());
    }
    return a(paramContext, parambz.ej.iJ, paramaq);
  }
  
  public static cb a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      localch = new ch();
      paramString2 = new URL(paramString2);
      i = 0;
    }
    catch (IOException paramContext)
    {
      try
      {
        for (;;)
        {
          ch localch;
          int i;
          co.a(paramContext, paramString1, false, localHttpURLConnection);
          int j = localHttpURLConnection.getResponseCode();
          Map localMap = localHttpURLConnection.getHeaderFields();
          if ((j >= 200) && (j < 300))
          {
            paramContext = paramString2.toString();
            paramString1 = co.a(new InputStreamReader(localHttpURLConnection.getInputStream()));
            a(paramContext, localMap, paramString1, j);
            localch.a(paramContext, localMap, paramString1);
            paramContext = localch.aq();
            return paramContext;
          }
          a(paramString2.toString(), localMap, null, j);
          if ((j >= 300) && (j < 400))
          {
            paramString2 = localHttpURLConnection.getHeaderField("Location");
            if (TextUtils.isEmpty(paramString2))
            {
              ct.v("No location header to follow redirect.");
              paramContext = new cb(0);
              return paramContext;
            }
            paramString2 = new URL(paramString2);
            i += 1;
            if (i > 5)
            {
              ct.v("Too many redirects.");
              paramContext = new cb(0);
              return paramContext;
            }
          }
          else
          {
            ct.v("Received error HTTP response code: " + j);
            paramContext = new cb(0);
            return paramContext;
          }
          localch.d(localMap);
          localHttpURLConnection.disconnect();
        }
      }
      finally
      {
        HttpURLConnection localHttpURLConnection;
        localHttpURLConnection.disconnect();
      }
      paramContext = paramContext;
      ct.v("Error while connecting to ad server: " + paramContext.getMessage());
      return new cb(2);
    }
    localHttpURLConnection = (HttpURLConnection)paramString2.openConnection();
  }
  
  public static ce a(Context paramContext, aq paramaq)
  {
    synchronized (hC)
    {
      if (hD == null) {
        hD = new ce(paramContext.getApplicationContext(), paramaq);
      }
      paramContext = hD;
      return paramContext;
    }
  }
  
  private static void a(String paramString1, Map<String, List<String>> paramMap, String paramString2, int paramInt)
  {
    if (ct.n(2))
    {
      ct.u("Http Response: {\n  URL:\n    " + paramString1 + "\n  Headers:");
      if (paramMap != null)
      {
        paramString1 = paramMap.keySet().iterator();
        while (paramString1.hasNext())
        {
          Object localObject = (String)paramString1.next();
          ct.u("    " + (String)localObject + ":");
          localObject = ((List)paramMap.get(localObject)).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            ct.u("      " + str);
          }
        }
      }
      ct.u("  Body:");
      if (paramString2 != null)
      {
        int i = 0;
        while (i < Math.min(paramString2.length(), 100000))
        {
          ct.u(paramString2.substring(i, Math.min(paramString2.length(), i + 1000)));
          i += 1000;
        }
      }
      ct.u("    null");
      ct.u("  Response Code:\n    " + paramInt + "\n}");
    }
  }
  
  public cb b(bz parambz)
  {
    return a(this.mContext, this.hE, parambz);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */