package com.gau.go.launcherex.gowidget.scriptengine.parser;

import org.xmlpull.v1.XmlPullParser;

public class w
{
  private String a(XmlPullParser paramXmlPullParser)
  {
    return paramXmlPullParser.getAttributeValue(null, "src");
  }
  
  public void a(XmlPullParser paramXmlPullParser, i parami)
  {
    if ((paramXmlPullParser == null) || (parami == null)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        if (paramXmlPullParser.next() == 1) {
          break;
        }
        localObject = paramXmlPullParser.getName();
        if (localObject == null) {
          continue;
        }
        i = paramXmlPullParser.getEventType();
        if ((!((String)localObject).equals("weather_icon")) || (i != 2)) {
          break label487;
        }
        if (paramXmlPullParser.next() == 1) {
          continue;
        }
        localObject = paramXmlPullParser.getName();
        if (localObject == null) {
          continue;
        }
        i = paramXmlPullParser.getEventType();
        if (i != 2) {
          break label469;
        }
        if (((String)localObject).equals("go_weatherex_main_editcity_bg_unknow"))
        {
          e.a(parami, 1, a(paramXmlPullParser));
          continue;
        }
        if (!((String)localObject).equals("go_weatherex_main_editcity_bg_unknow_night")) {
          break label141;
        }
      }
      catch (Exception paramXmlPullParser)
      {
        paramXmlPullParser.printStackTrace();
        return;
      }
      e.b(parami, 1, a(paramXmlPullParser));
      continue;
      label141:
      if (((String)localObject).equals("go_weatherex_main_editcity_bg_sun"))
      {
        e.a(parami, 2, a(paramXmlPullParser));
      }
      else if (((String)localObject).equals("go_weatherex_main_editcity_bg_sun_night"))
      {
        e.b(parami, 2, a(paramXmlPullParser));
      }
      else if (((String)localObject).equals("go_weatherex_main_editcity_bg_cloud"))
      {
        e.a(parami, 3, a(paramXmlPullParser));
      }
      else if (((String)localObject).equals("go_weatherex_main_editcity_bg_cloud_night"))
      {
        e.b(parami, 3, a(paramXmlPullParser));
      }
      else if (((String)localObject).equals("go_weatherex_main_editcity_bg_dark_cloud"))
      {
        e.a(parami, 4, a(paramXmlPullParser));
      }
      else if (((String)localObject).equals("go_weatherex_main_editcity_bg_dark_cloud_night"))
      {
        e.b(parami, 4, a(paramXmlPullParser));
      }
      else if (((String)localObject).equals("go_weatherex_main_editcity_bg_snow"))
      {
        e.a(parami, 5, a(paramXmlPullParser));
      }
      else if (((String)localObject).equals("go_weatherex_main_editcity_bg_snow_night"))
      {
        e.b(parami, 5, a(paramXmlPullParser));
      }
      else if (((String)localObject).equals("go_weatherex_main_editcity_bg_fog"))
      {
        e.a(parami, 6, a(paramXmlPullParser));
      }
      else if (((String)localObject).equals("go_weatherex_main_editcity_bg_fog_night"))
      {
        e.b(parami, 6, a(paramXmlPullParser));
      }
      else if (((String)localObject).equals("go_weatherex_main_editcity_bg_rain"))
      {
        e.a(parami, 7, a(paramXmlPullParser));
      }
      else if (((String)localObject).equals("go_weatherex_main_editcity_bg_rain_night"))
      {
        e.b(parami, 7, a(paramXmlPullParser));
      }
      else if (((String)localObject).equals("go_weatherex_main_editcity_bg_thunderstorm"))
      {
        e.a(parami, 8, a(paramXmlPullParser));
      }
      else if (((String)localObject).equals("go_weatherex_main_editcity_bg_thunderstorm_night"))
      {
        e.b(parami, 8, a(paramXmlPullParser));
        continue;
        label469:
        if ((((String)localObject).equals("weather_icon")) && (i == 3)) {
          label487:
          if ((goto 9) && (((((String)localObject).equals("sun_day_text_84")) && (i == 2)) || ((((String)localObject).equals("sun_night_text_84")) && (i == 2)) || ((((String)localObject).equals("cloud_day_text_84")) && (i == 2)) || ((((String)localObject).equals("cloud_night_text_84")) && (i == 2)) || ((((String)localObject).equals("dark_cloud_day_text_84")) && (i == 2)) || ((((String)localObject).equals("dark_cloud_night_text_84")) && (i == 2)) || ((((String)localObject).equals("snow_day_text_84")) && (i == 2)) || ((((String)localObject).equals("snow_night_text_84")) && (i == 2)) || ((((String)localObject).equals("fog_day_text_84")) && (i == 2)) || ((((String)localObject).equals("fog_night_text_84")) && (i == 2)) || ((((String)localObject).equals("rain_day_text_84")) && (i == 2)) || ((((String)localObject).equals("rain_night_text_84")) && (i == 2)) || ((((String)localObject).equals("thunderstorm_day_text_84")) && (i == 2)) || ((((String)localObject).equals("thunderstorm_night_text_84")) && (i == 2))))
          {
            localObject = new ac();
            String str1;
            while (paramXmlPullParser.next() != 1)
            {
              str1 = paramXmlPullParser.getName();
              if (str1 != null)
              {
                i = paramXmlPullParser.getEventType();
                if ((!str1.equals("gw_weather_ex_main_selector")) && (!str1.equals("go_weather_ex_main_shadowcolor"))) {
                  break label784;
                }
                String str2 = paramXmlPullParser.getAttributeValue(null, "src");
                if (str2 != null) {
                  ((ac)localObject).a(str1, str2);
                }
              }
            }
            continue;
            label784:
            if (((!str1.equals("sun_day_text_84")) || (i != 3)) && ((!str1.equals("sun_night_text_84")) || (i != 3)) && ((!str1.equals("cloud_day_text_84")) || (i != 3)) && ((!str1.equals("cloud_night_text_84")) || (i != 3)) && ((!str1.equals("dark_cloud_day_text_84")) || (i != 3)) && ((!str1.equals("dark_cloud_night_text_84")) || (i != 3)) && ((!str1.equals("snow_day_text_84")) || (i != 3)) && ((!str1.equals("snow_night_text_84")) || (i != 3)) && ((!str1.equals("fog_day_text_84")) || (i != 3)) && ((!str1.equals("fog_night_text_84")) || (i != 3)) && ((!str1.equals("rain_day_text_84")) || (i != 3)) && ((!str1.equals("rain_night_text_84")) || (i != 3)) && ((!str1.equals("thunderstorm_day_text_84")) || (i != 3)) && ((!str1.equals("thunderstorm_night_text_84")) || (i != 3))) {
              break;
            }
            parami.a(str1, (ac)localObject);
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */