package com.gau.go.launcherex.gowidget.weather.widget.dynamicicon;

import android.content.Context;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.scriptengine.parser.z;
import com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a.b;
import com.jiubang.core.a.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public class a
{
  private Context a;
  private String b;
  private int c;
  private int d;
  private HashMap e;
  private HashMap f;
  private HashMap g;
  private ArrayList h;
  
  private l a(String paramString)
  {
    paramString = (WeakReference)this.e.get(paramString);
    if (paramString != null) {
      return (l)paramString.get();
    }
    return null;
  }
  
  private void a(z paramz, String paramString)
  {
    if ((paramz != null) && (!TextUtils.isEmpty(paramString))) {
      this.f.put(paramString, new WeakReference(paramz));
    }
  }
  
  private z b(String paramString)
  {
    paramString = (WeakReference)this.f.get(paramString);
    if (paramString != null) {
      return (z)paramString.get();
    }
    return null;
  }
  
  private String b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      switch (paramInt)
      {
      default: 
        if (paramBoolean2) {
          return "gowidget/weather_dynamic_icon_na_day.xml";
        }
        break;
      case 3: 
        if (paramBoolean2) {
          return "gowidget/weather_dynamic_icon_cloudy_day.xml";
        }
        return "gowidget/weather_dynamic_icon_cloudy_night.xml";
      case 6: 
        if (paramBoolean2) {
          return "gowidget/weather_dynamic_icon_foggy_day.xml";
        }
        return "gowidget/weather_dynamic_icon_foggy_night.xml";
      case 4: 
        if (paramBoolean2) {
          return "gowidget/weather_dynamic_icon_overcast_day.xml";
        }
        return "gowidget/weather_dynamic_icon_overcast_night.xml";
      case 7: 
        if (paramBoolean2) {
          return "gowidget/weather_dynamic_icon_rainy_day.xml";
        }
        return "gowidget/weather_dynamic_icon_rainy_night.xml";
      case 5: 
        if (paramBoolean2) {
          return "gowidget/weather_dynamic_icon_snowy_day.xml";
        }
        return "gowidget/weather_dynamic_icon_snowy_night.xml";
      case 2: 
        if (paramBoolean2) {
          return "gowidget/weather_dynamic_icon_sunny_day.xml";
        }
        return "gowidget/weather_dynamic_icon_sunny_night.xml";
      case 8: 
        if (paramBoolean2) {
          return "gowidget/weather_dynamic_icon_thunderstorm_day.xml";
        }
        return "gowidget/weather_dynamic_icon_thunderstorm_night.xml";
      }
      return "gowidget/weather_dynamic_icon_na_night.xml";
    }
    switch (paramInt)
    {
    default: 
      if (paramBoolean2) {
        return "gowidget/weather_icon_na_day.xml";
      }
      break;
    case 3: 
      if (paramBoolean2) {
        return "gowidget/weather_icon_cloudy_day.xml";
      }
      return "gowidget/weather_icon_cloudy_night.xml";
    case 6: 
      if (paramBoolean2) {
        return "gowidget/weather_icon_foggy_day.xml";
      }
      return "gowidget/weather_icon_foggy_night.xml";
    case 4: 
      if (paramBoolean2) {
        return "gowidget/weather_icon_overcast_day.xml";
      }
      return "gowidget/weather_icon_overcast_night.xml";
    case 7: 
      if (paramBoolean2) {
        return "gowidget/weather_icon_rainy_day.xml";
      }
      return "gowidget/weather_icon_rainy_night.xml";
    case 5: 
      if (paramBoolean2) {
        return "gowidget/weather_icon_snowy_day.xml";
      }
      return "gowidget/weather_icon_snowy_night.xml";
    case 2: 
      if (paramBoolean2) {
        return "gowidget/weather_icon_sunny_day.xml";
      }
      return "gowidget/weather_icon_sunny_night.xml";
    case 8: 
      if (paramBoolean2) {
        return "gowidget/weather_icon_thunderstorm_day.xml";
      }
      return "gowidget/weather_icon_thunderstorm_night.xml";
    }
    return "gowidget/weather_icon_na_night.xml";
  }
  
  public l a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(b(paramInt, paramBoolean2, paramBoolean1));
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, b paramb)
  {
    String str = b(paramInt, paramBoolean2, paramBoolean1);
    d locald = new d(this, null);
    locald.h = paramb;
    locald.d = paramInt;
    locald.e = paramBoolean1;
    locald.f = paramBoolean2;
    locald.c = str;
    locald.g = this.b;
    locald.b = b(str);
    if (this.g.get(locald.c) == null)
    {
      this.g.put(locald.c, locald.c);
      new c(this, null).execute(new d[] { locald });
      return;
    }
    this.h.add(locald);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/widget/dynamicicon/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */