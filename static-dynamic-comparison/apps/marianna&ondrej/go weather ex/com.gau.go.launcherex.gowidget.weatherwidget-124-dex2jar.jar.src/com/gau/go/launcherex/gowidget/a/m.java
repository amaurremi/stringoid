package com.gau.go.launcherex.gowidget.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.gau.go.launcherex.gowidget.weather.f.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class m
{
  public static Map a(Context paramContext, int paramInt)
  {
    localHashMap = null;
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    paramContext = localHashMap;
    if (localXmlResourceParser != null) {
      localHashMap = new HashMap();
    }
    try
    {
      for (paramInt = localXmlResourceParser.getEventType();; paramInt = localXmlResourceParser.next())
      {
        paramContext = localHashMap;
        if (paramInt == 1) {
          break;
        }
        if (paramInt == 2)
        {
          paramContext = localXmlResourceParser.getName();
          if ((paramContext != null) && (paramContext.equals("country"))) {
            localHashMap.put(localXmlResourceParser.getAttributeValue(null, "language"), Integer.valueOf(localXmlResourceParser.getAttributeIntValue(null, "price", 75)));
          }
        }
      }
      return localHashMap;
    }
    catch (XmlPullParserException paramContext)
    {
      paramContext.printStackTrace();
      paramContext = localHashMap;
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static Map b(Context paramContext, int paramInt)
  {
    localHashMap = null;
    XmlPullParser localXmlPullParser = g.a(paramContext.getResources().openRawResource(paramInt));
    paramContext = localHashMap;
    if (localXmlPullParser != null) {
      localHashMap = new HashMap();
    }
    try
    {
      for (paramInt = localXmlPullParser.getEventType();; paramInt = localXmlPullParser.next())
      {
        paramContext = localHashMap;
        if (paramInt == 1) {
          break;
        }
        if (paramInt == 2)
        {
          paramContext = localXmlPullParser.getName();
          if ((paramContext != null) && (paramContext.equals("country"))) {
            localHashMap.put(localXmlPullParser.getAttributeValue(null, "language"), Integer.valueOf(Integer.valueOf(localXmlPullParser.getAttributeValue(null, "price")).intValue()));
          }
        }
      }
      return localHashMap;
    }
    catch (XmlPullParserException paramContext)
    {
      paramContext.printStackTrace();
      paramContext = localHashMap;
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */