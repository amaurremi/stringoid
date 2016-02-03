package com.ideashower.readitlater.util;

import android.webkit.URLUtil;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class y
{
  private static Pattern a;
  
  public static ArrayList a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public static ArrayList a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    int i;
    ArrayList localArrayList;
    if (paramInt > 0)
    {
      i = 1;
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      try
      {
        if (a == null) {
          a = Pattern.compile("\\b((?:[a-z][\\w-]+:(?:/{1,3}|[a-z0-9%])|www\\d{0,3}[.]|[a-z0-9.\\-]+[.][a-z]{2,4}/)(?:[^\\s()<>]+|\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\))+(?:\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\)|[^\\s`!()\\[\\]{};:'\".,<>?«»“”‘’]))", 2);
        }
        paramString = a.matcher(paramString);
      }
      catch (Throwable paramString)
      {
        String str;
        e.a(paramString, true);
        return null;
      }
      if (paramString.find())
      {
        str = paramString.group();
        if (!URLUtil.isValidUrl(str)) {
          break label96;
        }
        localArrayList.add(str);
        paramInt -= 1;
        break label96;
        i = 0;
        break;
      }
      label96:
      do
      {
        return localArrayList;
        if (i == 0) {
          break;
        }
      } while (paramInt <= 0);
    }
  }
  
  public static String b(String paramString)
  {
    paramString = a(paramString, 1);
    if ((paramString == null) || (paramString.isEmpty())) {
      return null;
    }
    return (String)paramString.get(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */