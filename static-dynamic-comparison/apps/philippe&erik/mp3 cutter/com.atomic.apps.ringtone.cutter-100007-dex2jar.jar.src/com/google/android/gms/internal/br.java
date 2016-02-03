package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.atomic.apps.ringtone.cutter.aa;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class br
  extends bp
{
  private static final Object a = new Object();
  private static br b;
  private final Context c;
  private final V d;
  private final F e;
  
  private br(Context paramContext, F paramF, V paramV)
  {
    this.c = paramContext;
    this.d = paramV;
    this.e = paramF;
  }
  
  public static br a(Context paramContext, F paramF, V paramV)
  {
    synchronized (a)
    {
      if (b == null) {
        b = new br(paramContext.getApplicationContext(), paramF, paramV);
      }
      paramContext = b;
      return paramContext;
    }
  }
  
  public static cz a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      localby = new by();
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
          by localby;
          long l;
          int i;
          bN.a(paramContext, paramString1, false, localHttpURLConnection);
          int j = localHttpURLConnection.getResponseCode();
          Map localMap = localHttpURLConnection.getHeaderFields();
          if ((j >= 200) && (j < 300))
          {
            paramContext = paramString2.toString();
            paramString1 = bN.a(new InputStreamReader(localHttpURLConnection.getInputStream()));
            a(paramContext, localMap, paramString1, j);
            localby.a(paramContext, localMap, paramString1);
            paramContext = localby.a(l);
            return paramContext;
          }
          a(paramString2.toString(), localMap, null, j);
          if ((j >= 300) && (j < 400))
          {
            paramString2 = localHttpURLConnection.getHeaderField("Location");
            if (TextUtils.isEmpty(paramString2))
            {
              aa.e("No location header to follow redirect.");
              paramContext = new cz(0);
              return paramContext;
            }
            paramString2 = new URL(paramString2);
            i += 1;
            if (i > 5)
            {
              aa.e("Too many redirects.");
              paramContext = new cz(0);
              return paramContext;
            }
          }
          else
          {
            aa.e("Received error HTTP response code: " + j);
            paramContext = new cz(0);
            return paramContext;
          }
          localby.a(localMap);
          localHttpURLConnection.disconnect();
        }
      }
      finally
      {
        HttpURLConnection localHttpURLConnection;
        localHttpURLConnection.disconnect();
      }
      paramContext = paramContext;
      aa.e("Error while connecting to ad server: " + paramContext.getMessage());
      return new cz(2);
    }
    localHttpURLConnection = (HttpURLConnection)paramString2.openConnection();
  }
  
  private static void a(String paramString1, Map paramMap, String paramString2, int paramInt)
  {
    if (aa.a(2))
    {
      aa.d("Http Response: {\n  URL:\n    " + paramString1 + "\n  Headers:");
      if (paramMap != null)
      {
        paramString1 = paramMap.keySet().iterator();
        while (paramString1.hasNext())
        {
          Object localObject = (String)paramString1.next();
          aa.d("    " + (String)localObject + ":");
          localObject = ((List)paramMap.get(localObject)).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            aa.d("      " + str);
          }
        }
      }
      aa.d("  Body:");
      if (paramString2 != null)
      {
        int i = 0;
        while (i < Math.min(paramString2.length(), 100000))
        {
          aa.d(paramString2.substring(i, Math.min(paramString2.length(), i + 1000)));
          i += 1000;
        }
      }
      aa.d("    null");
      aa.d("  Response Code:\n    " + paramInt + "\n}");
    }
  }
  
  public final cz a(cx paramcx)
  {
    Context localContext = this.c;
    Object localObject2 = this.e;
    Object localObject1 = this.d;
    aa.a("Starting ad request from service.");
    Object localObject3 = new bz(localContext);
    if (((bz)localObject3).l == -1)
    {
      aa.a("Device is offline.");
      return new cz(2);
    }
    localObject1 = new bv(paramcx.f.packageName);
    if (paramcx.c.c != null)
    {
      String str = paramcx.c.c.getString("_ad");
      if (str != null) {
        return bu.a(localContext, paramcx, str);
      }
    }
    localObject2 = ((F)localObject2).a();
    localObject3 = bu.a(paramcx, (bz)localObject3, null);
    if (localObject3 == null) {
      return new cz(0);
    }
    localObject3 = new bt((String)localObject3);
    bU.a.post(new bs(localContext, paramcx, (bv)localObject1, (ca)localObject3, (String)localObject2));
    localObject2 = ((bv)localObject1).b();
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return new cz(((bv)localObject1).a());
    }
    return a(localContext, paramcx.k.b, (String)localObject2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */