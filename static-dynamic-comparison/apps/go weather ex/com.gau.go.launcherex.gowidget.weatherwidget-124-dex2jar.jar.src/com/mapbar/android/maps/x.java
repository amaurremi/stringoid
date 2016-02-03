package com.mapbar.android.maps;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import com.mapbar.map.MapPoint;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

public class x
{
  public static String a = "";
  public static String b = "";
  public static int c;
  public static int d;
  public static int e;
  public static String f = "";
  public static long g;
  public static int h;
  public static int i;
  public static int j;
  public static int k;
  public static int l;
  public static int m;
  public static int n;
  public static String o;
  public static int p;
  public static int q;
  public static int r;
  public static int s;
  public static String t;
  private static int u = 0;
  private static String v;
  private static MessageDigest w;
  
  static
  {
    h = 0;
    t = "";
    v = null;
    try
    {
      w = MessageDigest.getInstance("MD5");
      return;
    }
    catch (Exception localException) {}
  }
  
  public static String a(MapView paramMapView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    i1 = 0;
    localObject1 = new StringBuilder();
    try
    {
      ((StringBuilder)localObject1).append(v.b(D.d)).append(";");
      ((StringBuilder)localObject1).append(u).append(";");
      localObject2 = paramMapView.getMapCenter().getMapPoint();
      ((StringBuilder)localObject1).append(((MapPoint)localObject2).getLongitude()).append(",").append(((MapPoint)localObject2).getLatitude()).append(",").append("cn").append(";");
      ((StringBuilder)localObject1).append(paramMapView.getZoomLevel()).append(";");
      if ((SystemClock.elapsedRealtime() - g) / 1000L > 60L)
      {
        c = 0;
        d = 0;
        e = 0;
        f = "";
      }
      ((StringBuilder)localObject1).append(c).append(",").append(d).append(",").append(e).append(",").append(f).append(";");
      localObject2 = paramMapView.getOverlays();
      if (localObject2 == null) {
        break label626;
      }
      ((StringBuilder)localObject1).append(((List)localObject2).size()).append(";");
    }
    catch (Exception paramMapView)
    {
      try
      {
        for (;;)
        {
          localObject2 = paramMapView.getContext().getPackageManager().getPackageInfo(D.d, 0);
          v = URLEncoder.encode(((PackageInfo)localObject2).applicationInfo.loadLabel(paramMapView.getContext().getPackageManager()).toString(), "utf-8");
          v = v + "_" + ((PackageInfo)localObject2).versionName;
          v = "@" + v;
          ((StringBuilder)localObject1).append(D.d).append(v).append(";");
          if (!paramBoolean) {
            break;
          }
          ((StringBuilder)localObject1).append(D.i).append(",").append("").append(",").append(0).append(",").append(0).append(",").append(0).append(";");
          for (paramMapView = (MapView)localObject1;; paramMapView = new StringBuilder())
          {
            E.a("MV", paramMapView.toString());
            localObject2 = a(paramMapView.toString());
            try
            {
              paramMapView = w.a(b(paramMapView.toString()), "iso-8859-1");
            }
            catch (Exception paramMapView)
            {
              for (;;)
              {
                paramMapView = "";
              }
            }
            try
            {
              localObject1 = paramMapView.replaceAll("\n", "").replaceAll("\r", "");
              paramMapView = (MapView)localObject1;
            }
            catch (Exception localException)
            {
              break label596;
            }
            return "[Android][" + (String)localObject2 + "]" + paramMapView;
            ((StringBuilder)localObject1).append(0).append(";");
            break;
            paramMapView = paramMapView;
          }
          ((StringBuilder)localObject1).append(0).append(";");
        }
        ((StringBuilder)localObject1).append(0).append(";");
      }
      catch (Exception paramMapView)
      {
        for (;;)
        {
          paramMapView.printStackTrace();
        }
        paramInt1 = i1;
        if (s <= 0) {
          break label708;
        }
        paramInt1 = r / s;
        Object localObject2 = ((StringBuilder)localObject1).append(D.i).append(",");
        if (o != null) {
          break label781;
        }
        for (paramMapView = "";; paramMapView = o)
        {
          ((StringBuilder)localObject2).append(paramMapView).append(",").append(q).append(",").append(p).append(",").append(paramInt1).append(";");
          paramMapView = (MapView)localObject1;
          break;
        }
      }
    }
    ((StringBuilder)localObject1).append(h).append(";");
    if (paramMapView.isTraffic())
    {
      ((StringBuilder)localObject1).append(1).append(";");
      if (!paramBoolean) {
        break label668;
      }
      ((StringBuilder)localObject1).append(1).append(";");
      ((StringBuilder)localObject1).append(l).append(",").append(k).append(",").append(j).append(",").append(i).append(";");
      ((StringBuilder)localObject1).append(n).append(",").append(m).append(";");
      ((StringBuilder)localObject1).append(paramInt1).append(",").append(paramInt2).append(";");
      localObject2 = v;
      if (localObject2 != null) {}
    }
  }
  
  private static String a(String paramString)
  {
    for (;;)
    {
      String str2;
      String str1;
      try
      {
        str2 = new String();
        str1 = str2;
      }
      finally {}
      try
      {
        if (w != null)
        {
          paramString = w.digest(("MAPBAR" + paramString + "ANDROID").getBytes());
          str1 = str2;
          if (paramString != null) {
            str1 = w.a(paramString, "iso-8859-1");
          }
        }
      }
      catch (Exception paramString)
      {
        str1 = str2;
      }
    }
    return str1;
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      paramContext = new A(paramContext, 3, 0, true);
      paramContext.a("http://wlog.mapbar.com/search/?&tp=35_2&ch=UTF-8");
      paramContext.a(new z()
      {
        public final void downloadEnd(Object paramAnonymousObject) {}
      });
      paramContext.b(new Object[0]);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(MapView paramMapView)
  {
    try
    {
      Object localObject = PreferenceManager.getDefaultSharedPreferences(paramMapView.getContext());
      int i1 = ((SharedPreferences)localObject).getInt("MAPBAR_MV_SESSION", u);
      u = i1;
      u = i1 + 1;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("MAPBAR_MV_SESSION", u);
      ((SharedPreferences.Editor)localObject).commit();
      try
      {
        h = 0;
        p = 0;
        q = 0;
        r = 0;
        s = 0;
        localObject = paramMapView.getMapCenter().getMapPoint();
        i1 = ((MapPoint)localObject).getLatitude();
        k = i1;
        i = i1;
        i1 = ((MapPoint)localObject).getLongitude();
        l = i1;
        j = i1;
        i1 = paramMapView.getZoomLevel();
        n = i1;
        m = i1;
        return;
      }
      catch (Exception paramMapView) {}
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private static byte[] b(String paramString)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
      localDeflaterOutputStream.write(paramString.getBytes());
      localDeflaterOutputStream.close();
      try
      {
        localByteArrayOutputStream.close();
        paramString = localByteArrayOutputStream.toByteArray();
        return paramString;
      }
      catch (IOException paramString)
      {
        for (;;) {}
      }
      return null;
    }
    catch (Exception paramString) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */