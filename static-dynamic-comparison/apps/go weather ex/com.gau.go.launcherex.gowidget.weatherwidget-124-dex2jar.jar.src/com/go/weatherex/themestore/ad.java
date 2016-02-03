package com.go.weatherex.themestore;

import android.content.Context;
import com.jiubang.playsdk.e.e;
import java.util.ArrayList;
import java.util.List;

public class ad
{
  public static List a(Context paramContext, List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      e locale = (e)paramList.get(i);
      if ((locale.f() != null) && (!com.jiubang.playsdk.g.a.d(paramContext, locale.f().c()))) {
        localArrayList.add(locale);
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */