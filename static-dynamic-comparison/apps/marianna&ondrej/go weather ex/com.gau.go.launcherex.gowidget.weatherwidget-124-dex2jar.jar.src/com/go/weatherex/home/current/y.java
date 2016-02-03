package com.go.weatherex.home.current;

import android.content.Context;
import android.view.LayoutInflater;
import com.go.weatherex.framework.fragment.a;

public class y
{
  public static CityWeatherInfoBase a(Context paramContext)
  {
    if (com.gau.go.launcherex.gowidget.statistics.y.k(paramContext).equals("zh")) {
      return (CityWeatherInfoBase)LayoutInflater.from(paramContext).inflate(2130903089, null, false);
    }
    if (com.gau.go.launcherex.gowidget.statistics.y.k(paramContext).equals("en")) {
      return (CityWeatherInfoBase)LayoutInflater.from(paramContext).inflate(2130903090, null, false);
    }
    return (CityWeatherInfoBase)LayoutInflater.from(paramContext).inflate(2130903088, null, false);
  }
  
  public static x a(a parama, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new d(parama, paramInt);
    case 2: 
      return new b(parama, paramInt);
    case 3: 
      return new c(parama, paramInt);
    case 4: 
      return new o(parama, paramInt);
    case 5: 
      return new m(parama, paramInt);
    }
    return new h(parama, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */