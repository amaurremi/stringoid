package com.gau.go.launcherex.gowidget.weather.f;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import org.xmlpull.v1.XmlPullParser;

public class e
{
  private boolean a;
  
  private int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString.substring(paramString.length() - 1));
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public static Drawable a(Resources paramResources, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i;
    if (paramString1 != null)
    {
      i = paramResources.getIdentifier(paramString1, "drawable", paramString2);
      localObject1 = localObject2;
      if (i == 0) {}
    }
    try
    {
      localObject1 = paramResources.getDrawable(i);
      return (Drawable)localObject1;
    }
    catch (OutOfMemoryError paramResources) {}
    return null;
  }
  
  private void a(XmlPullParser paramXmlPullParser, String[] paramArrayOfString, int paramInt)
  {
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "src");
    if (paramXmlPullParser != null) {
      paramArrayOfString[paramInt] = paramXmlPullParser;
    }
  }
  
  public static ColorStateList b(Resources paramResources, String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      int i = paramResources.getIdentifier(paramString1, "color", paramString2);
      if (i != 0) {
        return paramResources.getColorStateList(i);
      }
    }
    return null;
  }
  
  public boolean a(XmlPullParser paramXmlPullParser, a parama)
  {
    boolean bool2;
    label14:
    boolean bool1;
    if ((paramXmlPullParser == null) || (parama == null))
    {
      bool2 = false;
      return bool2;
      bool2 = bool1;
    }
    for (;;)
    {
      String str1;
      int i;
      int j;
      int k;
      int m;
      try
      {
        if (paramXmlPullParser.next() == 1) {
          break;
        }
        if (paramXmlPullParser.getName() == null) {
          break label14;
        }
        str1 = paramXmlPullParser.getName();
        i = paramXmlPullParser.getEventType();
        if (str1 == null) {
          break label14;
        }
        if ((str1.equals("widget")) && (i == 2))
        {
          str3 = paramXmlPullParser.getAttributeValue(null, "style_id");
          str2 = paramXmlPullParser.getAttributeValue(null, "theme_id");
          if (str3 == null) {
            break label1112;
          }
        }
      }
      catch (Exception paramXmlPullParser)
      {
        try
        {
          String str3;
          i = Integer.parseInt(str3);
          if (str2 == null) {
            break label1118;
          }
        }
        catch (NumberFormatException localNumberFormatException4)
        {
          String str2;
          localNumberFormatException4.printStackTrace();
        }
        try
        {
          j = Integer.parseInt(str2);
          str2 = parama.a("widget_style");
          if (str2 == null) {
            break label1125;
          }
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          localNumberFormatException1.printStackTrace();
        }
        try
        {
          k = Integer.parseInt(parama.a("widget_style"));
          str2 = parama.a("widget_theme_type");
          if (str2 == null) {
            break label1132;
          }
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          localNumberFormatException2.printStackTrace();
        }
        try
        {
          m = Integer.parseInt(parama.a("widget_theme_type"));
          bool2 = bool1;
          if (i == k)
          {
            bool2 = bool1;
            if (i != -100)
            {
              bool2 = bool1;
              if (m == j)
              {
                bool2 = bool1;
                if (m != -100)
                {
                  this.a = true;
                  bool2 = true;
                }
              }
            }
          }
          if ((!this.a) || ((!str1.equals("gw_weather_days_41_temp_minus")) && (!str1.equals("gw_weather_days_41_temp_unit")) && (!str1.equals("gw_weather_days_41_temp_unit_celsius")) && (!str1.equals("gw_weather_days_41_temp_unit_fahrenheit")) && (!str1.equals("gw_weather_days_41_time_divider")) && (!str1.equals("gw_weather_days_41_time_am")) && (!str1.equals("gw_weather_days_41_time_pm")) && (!str1.equals("gw_weather_days_41_bg")) && (!str1.equals("gw_weather_days_41_txt_selector")) && (!str1.equals("gw_weather_days_41_txt_shadow_color")) && (!str1.equals("gw_weather_days_41_txt_shadow_dx")) && (!str1.equals("gw_weather_days_41_txt_shadow_dy")) && (!str1.equals("gw_weather_days_41_txt_shadow_radius")) && (!str1.equals("gw_weather_days_41_refresh_selector")) && (!str1.equals("refresh_progress_days_41")) && (!str1.equals("gw_weather_days_41_early_warning")) && (!str1.equals("gw_weather_days_41_theme_setting_selector")) && (!str1.equals("gw_weather_days_41_arrow_next")) && (!str1.equals("gw_weather_days_41_arrow_previous")) && (!str1.equals("gw_weather_days_41_divider_forecast")))) {
            break label546;
          }
          str2 = paramXmlPullParser.getAttributeValue(null, "src");
          bool1 = bool2;
          if (str2 == null) {
            break label14;
          }
          parama.a(str1, str2);
          bool1 = bool2;
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          localNumberFormatException3.printStackTrace();
          break label1132;
        }
        paramXmlPullParser = paramXmlPullParser;
        paramXmlPullParser.printStackTrace();
        return false;
      }
      bool2 = bool1;
      if (str1.equals("widget"))
      {
        bool2 = bool1;
        if (i == 3)
        {
          bool2 = bool1;
          if (this.a)
          {
            this.a = false;
            return bool1;
            label546:
            if (str1.startsWith("gw_weather_days_41_time_num"))
            {
              a(paramXmlPullParser, parama.c(), a(str1));
              bool1 = bool2;
              break label14;
            }
            if (str1.startsWith("gw_weather_days_41_temp_num"))
            {
              a(paramXmlPullParser, parama.d(), a(str1));
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_unknown"))
            {
              a(paramXmlPullParser, parama.b(), 0);
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_sun"))
            {
              a(paramXmlPullParser, parama.b(), 1);
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_sun_night"))
            {
              a(paramXmlPullParser, parama.b(), 2);
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_cloudy"))
            {
              a(paramXmlPullParser, parama.b(), 3);
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_cloudy_night"))
            {
              a(paramXmlPullParser, parama.b(), 4);
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_darkcloudy"))
            {
              a(paramXmlPullParser, parama.b(), 5);
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_snow"))
            {
              a(paramXmlPullParser, parama.b(), 6);
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_fog"))
            {
              a(paramXmlPullParser, parama.b(), 7);
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_rain"))
            {
              a(paramXmlPullParser, parama.b(), 8);
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_thunder_storm"))
            {
              a(paramXmlPullParser, parama.b(), 9);
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_unknown_forecast"))
            {
              a(paramXmlPullParser, parama.a(), 0);
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_sun_forecast"))
            {
              a(paramXmlPullParser, parama.a(), 1);
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_cloudy_forecast"))
            {
              a(paramXmlPullParser, parama.a(), 2);
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_darkcloudy_forecast"))
            {
              a(paramXmlPullParser, parama.a(), 3);
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_snow_forecast"))
            {
              a(paramXmlPullParser, parama.a(), 4);
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_fog_forecast"))
            {
              a(paramXmlPullParser, parama.a(), 5);
              bool1 = bool2;
              break label14;
            }
            if (str1.equals("gw_weather_days_41_rain_forecast"))
            {
              a(paramXmlPullParser, parama.a(), 6);
              bool1 = bool2;
              break label14;
            }
            bool1 = bool2;
            if (!str1.equals("gw_weather_days_41_thunder_storm_forecast")) {
              break label14;
            }
            a(paramXmlPullParser, parama.a(), 7);
            bool1 = bool2;
            break label14;
            bool1 = false;
            break label14;
            label1112:
            i = -100;
            continue;
            label1118:
            j = -100;
            continue;
            label1125:
            k = -100;
            continue;
            label1132:
            m = -100;
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */