package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class dx
  extends dw.a
{
  private static final Object qp = new Object();
  private static dx qq;
  private final Context mContext;
  private final ed qr;
  private final bi qs;
  private final ay qt;
  
  dx(Context paramContext, ay paramay, bi parambi, ed paramed)
  {
    this.mContext = paramContext;
    this.qr = paramed;
    this.qs = parambi;
    this.qt = paramay;
  }
  
  private static du a(Context paramContext, final ay paramay, final bi parambi, ed paramed, final ds paramds)
  {
    eu.z("Starting ad request from service.");
    parambi.init();
    ec localec = new ec(paramContext);
    if (localec.rm == -1)
    {
      eu.z("Device is offline.");
      return new du(2);
    }
    final dz localdz = new dz(paramds.applicationInfo.packageName);
    if (paramds.pX.extras != null)
    {
      localObject = paramds.pX.extras.getString("_ad");
      if (localObject != null) {
        return dy.a(paramContext, paramds, (String)localObject);
      }
    }
    Object localObject = parambi.a(250L);
    parambi = paramay.aN();
    paramay = dy.a(paramds, localec, (Location)localObject, paramay.aO());
    if (paramay == null) {
      return new du(0);
    }
    paramay = s(paramay);
    et.sv.post(new Runnable()
    {
      public void run()
      {
        ex localex = ex.a(dx.this, new al(), false, false, null, paramds.kQ);
        localex.setWillNotDraw(true);
        localdz.b(localex);
        ey localey = localex.cb();
        localey.a("/invalidRequest", localdz.qD);
        localey.a("/loadAdURL", localdz.qE);
        localey.a("/log", bb.mZ);
        localey.a(paramay);
        eu.z("Loading the JS library.");
        localex.loadUrl(parambi);
      }
    });
    parambi = localdz.bx();
    if ((parambi == null) || (TextUtils.isEmpty(parambi.c()))) {
      return new du(localdz.getErrorCode());
    }
    paramay = null;
    if (parambi.e()) {
      paramay = paramed.u(paramds.pY.packageName);
    }
    return a(paramContext, paramds.kQ.sw, parambi.c(), paramay, parambi);
  }
  
  public static du a(Context paramContext, String paramString1, String paramString2, String paramString3, na paramna)
  {
    try
    {
      localea = new ea();
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
          ea localea;
          long l;
          int i;
          eo.a(paramContext, paramString1, false, localHttpURLConnection);
          if (!TextUtils.isEmpty(paramString3)) {
            localHttpURLConnection.addRequestProperty("x-afma-drt-cookie", paramString3);
          }
          if ((paramna != null) && (!TextUtils.isEmpty(paramna.b())))
          {
            localHttpURLConnection.setDoOutput(true);
            localObject = paramna.b().getBytes();
            localHttpURLConnection.setFixedLengthStreamingMode(localObject.length);
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localHttpURLConnection.getOutputStream());
            localBufferedOutputStream.write((byte[])localObject);
            localBufferedOutputStream.close();
          }
          int j = localHttpURLConnection.getResponseCode();
          Object localObject = localHttpURLConnection.getHeaderFields();
          if ((j >= 200) && (j < 300))
          {
            paramContext = paramString2.toString();
            paramString1 = eo.a(new InputStreamReader(localHttpURLConnection.getInputStream()));
            a(paramContext, (Map)localObject, paramString1, j);
            localea.a(paramContext, (Map)localObject, paramString1);
            paramContext = localea.i(l);
            return paramContext;
          }
          a(paramString2.toString(), (Map)localObject, null, j);
          if ((j >= 300) && (j < 400))
          {
            paramString2 = localHttpURLConnection.getHeaderField("Location");
            if (TextUtils.isEmpty(paramString2))
            {
              eu.D("No location header to follow redirect.");
              paramContext = new du(0);
              return paramContext;
            }
            paramString2 = new URL(paramString2);
            i += 1;
            if (i > 5)
            {
              eu.D("Too many redirects.");
              paramContext = new du(0);
              return paramContext;
            }
          }
          else
          {
            eu.D("Received error HTTP response code: " + j);
            paramContext = new du(0);
            return paramContext;
          }
          localea.d((Map)localObject);
          localHttpURLConnection.disconnect();
        }
      }
      finally
      {
        HttpURLConnection localHttpURLConnection;
        localHttpURLConnection.disconnect();
      }
      paramContext = paramContext;
      eu.D("Error while connecting to ad server: " + paramContext.getMessage());
      return new du(2);
    }
    localHttpURLConnection = (HttpURLConnection)paramString2.openConnection();
  }
  
  public static dx a(Context paramContext, ay paramay, bi parambi, ed paramed)
  {
    synchronized (qp)
    {
      if (qq == null) {
        qq = new dx(paramContext.getApplicationContext(), paramay, parambi, paramed);
      }
      paramContext = qq;
      return paramContext;
    }
  }
  
  private static void a(String paramString1, Map<String, List<String>> paramMap, String paramString2, int paramInt)
  {
    if (eu.p(2))
    {
      eu.C("Http Response: {\n  URL:\n    " + paramString1 + "\n  Headers:");
      if (paramMap != null)
      {
        paramString1 = paramMap.keySet().iterator();
        while (paramString1.hasNext())
        {
          Object localObject = (String)paramString1.next();
          eu.C("    " + (String)localObject + ":");
          localObject = ((List)paramMap.get(localObject)).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            eu.C("      " + str);
          }
        }
      }
      eu.C("  Body:");
      if (paramString2 != null)
      {
        int i = 0;
        while (i < Math.min(paramString2.length(), 100000))
        {
          eu.C(paramString2.substring(i, Math.min(paramString2.length(), i + 1000)));
          i += 1000;
        }
      }
      eu.C("    null");
      eu.C("  Response Code:\n    " + paramInt + "\n}");
    }
  }
  
  private static ey.a s(String paramString)
  {
    new ey.a()
    {
      public void a(ex paramAnonymousex)
      {
        String str = String.format("javascript:%s(%s);", new Object[] { "AFMA_buildAdURL", dx.this });
        eu.C("About to execute: " + str);
        paramAnonymousex.loadUrl(str);
      }
    };
  }
  
  public du b(ds paramds)
  {
    return a(this.mContext, this.qt, this.qs, this.qr, paramds);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */