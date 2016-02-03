package com.gtp.go.weather.billing.a;

import android.content.Context;
import com.gau.go.launcherex.gowidget.weather.f.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class l
{
  public static Map a(String paramString, Context paramContext)
  {
    Object localObject = null;
    paramString = g.b(paramContext, paramString, "countries_paytype");
    if (paramString == null) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      XmlPullParser localXmlPullParser = g.a(paramString);
      paramString = (String)localObject;
      if (localXmlPullParser == null) {
        continue;
      }
      paramContext = new HashMap();
      try
      {
        for (int i = localXmlPullParser.getEventType();; i = localXmlPullParser.next())
        {
          paramString = paramContext;
          if (i == 1) {
            break;
          }
          if (i == 2)
          {
            paramString = localXmlPullParser.getName();
            if ((paramString != null) && (paramString.equals("country"))) {
              paramContext.put(localXmlPullParser.getAttributeValue(null, "language"), localXmlPullParser.getAttributeValue(null, "paytype"));
            }
          }
        }
        return paramContext;
      }
      catch (XmlPullParserException paramString)
      {
        paramString.printStackTrace();
        return paramContext;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/billing/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */