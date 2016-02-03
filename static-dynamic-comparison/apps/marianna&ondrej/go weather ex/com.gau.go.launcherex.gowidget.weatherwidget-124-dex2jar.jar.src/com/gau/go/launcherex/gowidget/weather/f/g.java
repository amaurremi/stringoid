package com.gau.go.launcherex.gowidget.weather.f;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class g
{
  public static InputStream a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication(paramString1).getAssets().open(paramString2);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static XmlPullParser a(InputStream paramInputStream)
  {
    try
    {
      XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
      localXmlPullParser.setInput(paramInputStream, null);
      return localXmlPullParser;
    }
    catch (XmlPullParserException paramInputStream)
    {
      paramInputStream.printStackTrace();
      return null;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return null;
  }
  
  public static InputStream b(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      return null;
      try
      {
        paramContext = paramContext.createPackageContext(paramString1, 3);
        if (paramContext != null)
        {
          paramContext = paramContext.getResources();
          i = paramContext.getIdentifier(paramString2, "raw", paramString1);
          if (i == 0) {}
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          try
          {
            int i;
            paramContext = paramContext.openRawResource(i);
            return paramContext;
          }
          catch (Resources.NotFoundException paramContext)
          {
            paramContext.printStackTrace();
          }
          paramContext = paramContext;
          paramContext.printStackTrace();
          paramContext = null;
        }
      }
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/f/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */