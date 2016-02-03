package com.mapbar.android.location;

import android.content.Context;
import android.location.Address;
import android.util.Log;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public final class Geocoder
{
  private j a;
  
  public Geocoder(Context paramContext)
  {
    this(paramContext, Locale.getDefault());
  }
  
  public Geocoder(Context paramContext, Locale paramLocale)
  {
    if (paramLocale == null) {
      throw new NullPointerException("locale == null");
    }
    this.a = new j(paramContext, paramLocale);
  }
  
  public final List<Address> getFromLocation(double paramDouble1, double paramDouble2, int paramInt)
    throws IOException
  {
    if ((paramDouble1 < -90.0D) || (paramDouble1 > 90.0D)) {
      throw new IllegalArgumentException("latitude == " + paramDouble1);
    }
    if ((paramDouble2 < -180.0D) || (paramDouble2 > 180.0D)) {
      throw new IllegalArgumentException("longitude == " + paramDouble2);
    }
    try
    {
      Object localObject = this.a;
      ArrayList localArrayList = new ArrayList();
      if ((g.b) && (paramInt != 0))
      {
        int i = (int)(paramDouble2 * 100000.0D);
        int j = (int)(paramDouble1 * 100000.0D);
        String str = "http://wireless.mapbar.com/reverse/reverseGeocoding.json?q=" + h.a(i) + "," + h.a(j) + "&gb=02&ch=GBK&rn=" + paramInt + "&nq=2&format=true";
        u localu = new u(((j)localObject).a, 3, 0);
        localu.a(str);
        str = (String)localu.a();
        if (str != null)
        {
          localObject = h.a(((j)localObject).b, str);
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            localArrayList.addAll((Collection)localObject);
          }
        }
        return localArrayList;
      }
    }
    catch (Exception localException)
    {
      Log.e("Geocoder", "getFromLocation: got Exception", localException);
      return null;
    }
    return localException;
  }
  
  public final List<Address> getFromLocationName(String paramString, int paramInt)
    throws IOException
  {
    if (paramString == null) {
      throw new IllegalArgumentException("locationName == null");
    }
    try
    {
      paramString = this.a.a(paramString, paramInt);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("Geocoder", "getFromLocationName: got Exception", paramString);
    }
    return null;
  }
  
  public final List<Address> getFromLocationName(String paramString, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
    throws IOException
  {
    if (paramString == null) {
      throw new IllegalArgumentException("locationName == null");
    }
    if ((paramDouble1 < -90.0D) || (paramDouble1 > 90.0D)) {
      throw new IllegalArgumentException("lowerLeftLatitude == " + paramDouble1);
    }
    if ((paramDouble2 < -180.0D) || (paramDouble2 > 180.0D)) {
      throw new IllegalArgumentException("lowerLeftLongitude == " + paramDouble2);
    }
    if ((paramDouble3 < -90.0D) || (paramDouble3 > 90.0D)) {
      throw new IllegalArgumentException("upperRightLatitude == " + paramDouble3);
    }
    if ((paramDouble4 < -180.0D) || (paramDouble4 > 180.0D)) {
      throw new IllegalArgumentException("upperRightLongitude == " + paramDouble4);
    }
    if ((paramDouble1 == 0.0D) && (paramDouble2 == 0.0D) && (paramDouble3 == 0.0D) && (paramDouble4 == 0.0D)) {}
    try
    {
      return this.a.a(paramString, paramInt);
    }
    catch (Exception paramString)
    {
      j localj;
      ArrayList localArrayList;
      int k;
      int m;
      int j;
      int i;
      StringBuilder localStringBuilder;
      Log.e("Geocoder", "getFromLocationName: got Exception", paramString);
    }
    localj = this.a;
    localArrayList = new ArrayList();
    if (!g.b) {
      return localArrayList;
    }
    k = (int)((paramDouble2 + paramDouble4) / 2.0D * 100000.0D);
    m = (int)((paramDouble1 + paramDouble3) / 2.0D * 100000.0D);
    j = Math.max((int)((paramDouble4 - paramDouble2) / 2.0D * 100000.0D), (int)((paramDouble3 - paramDouble1) / 2.0D * 100000.0D));
    i = j;
    if (j < 500) {
      i = 500;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(localj.a()).append("ch=UTF-8&fd=5&rn=").append(paramInt).append("&pn=1&tp=2&cp=").append(h.a(k)).append(",").append(h.a(m)).append("&m=").append(i).append("&q=").append(URLEncoder.encode(paramString, "utf-8"));
    paramString = new u(localj.a, 3, 0);
    paramString.a(localStringBuilder.toString());
    paramString = (String)paramString.a();
    if (paramString != null)
    {
      paramString = h.b(localj.b, paramString);
      if (paramString != null) {
        localArrayList.addAll(paramString);
      }
    }
    return localArrayList;
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/location/Geocoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */