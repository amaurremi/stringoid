package com.go.weatherex.home.current;

import android.text.TextUtils;
import android.view.View;
import com.gau.go.launcherex.gowidget.weather.scroller.WeatherDetailScrollGroup;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.w;
import com.go.weatherex.framework.e;
import com.go.weatherex.home.current.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class v
  extends e
{
  private v(t paramt) {}
  
  public void a()
  {
    t.d(this.a);
    int i = 0;
    while (i < t.a(this.a).getChildCount())
    {
      CurrentWeatherContent localCurrentWeatherContent = (CurrentWeatherContent)t.a(this.a).getChildAt(i);
      if ((localCurrentWeatherContent != null) && (localCurrentWeatherContent.h() != null)) {
        localCurrentWeatherContent.h().d();
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    t.d(this.a);
    int i = 0;
    while (i < t.a(this.a).getChildCount())
    {
      CurrentWeatherContent localCurrentWeatherContent = (CurrentWeatherContent)t.a(this.a).getChildAt(i);
      if ((localCurrentWeatherContent != null) && (localCurrentWeatherContent.h() != null)) {
        localCurrentWeatherContent.h().b(paramInt);
      }
      i += 1;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = t.e(this.a);
      paramString2.a(paramString1);
      paramString2.a(this.a);
      paramString2.a();
      t.a(this.a).addView(paramString2);
      t.a(this.a).a();
      t.a(this.a).a(t.a(this.a).getChildCount() - 1);
      t.a(this.a, paramString1);
      if (t.a(this.a).getChildCount() == 1)
      {
        t.a(this.a, 0);
        paramString2.setOnScrollListener(this.a);
      }
    }
  }
  
  public void a(List paramList, int paramInt)
  {
    int k = t.a(this.a).getChildCount();
    if ((paramList == null) || (paramList.isEmpty()) || (k <= 1)) {
      return;
    }
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    int i;
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!TextUtils.isEmpty(str))
      {
        i = 0;
        while (i < k)
        {
          CurrentWeatherContent localCurrentWeatherContent = (CurrentWeatherContent)t.a(this.a).getChildAt(i);
          if ((localCurrentWeatherContent != null) && (str.equals(localCurrentWeatherContent.c()))) {
            ((ArrayList)localObject).add(localCurrentWeatherContent);
          }
          i += 1;
        }
      }
    }
    int j;
    if (!((ArrayList)localObject).isEmpty())
    {
      paramList = ((ArrayList)localObject).iterator();
      i = 0;
      j = i;
      if (paramList.hasNext())
      {
        localObject = (CurrentWeatherContent)paramList.next();
        if (t.a(this.a).indexOfChild((View)localObject) == t.g(this.a)) {}
        for (j = 1;; j = 0)
        {
          i |= j;
          t.a(this.a).removeView((View)localObject);
          ((CurrentWeatherContent)localObject).f();
          break;
        }
      }
    }
    else
    {
      j = 0;
    }
    t.a(this.a).a();
    paramList = this.a;
    if (paramInt < k) {}
    for (;;)
    {
      t.a(paramList, paramInt);
      t.a(this.a).a(t.g(this.a));
      t.h(this.a);
      t.i(this.a);
      if (j == 0) {
        break;
      }
      this.a.a(12, t.j(this.a), 10L, true);
      return;
      paramInt = k - 1;
    }
  }
  
  public void a(List paramList, w paramw)
  {
    int j = 0;
    int i = 0;
    CurrentWeatherContent localCurrentWeatherContent;
    if (i < t.a(this.a).getChildCount())
    {
      localCurrentWeatherContent = (CurrentWeatherContent)t.a(this.a).getChildAt(i);
      if (localCurrentWeatherContent == null) {}
      for (;;)
      {
        i += 1;
        break;
        localCurrentWeatherContent.b();
        localCurrentWeatherContent.a(paramw);
      }
    }
    i = j;
    if (!t.b(this.a))
    {
      t.a(this.a, true);
      t.c(this.a);
      i = j;
    }
    while (i < t.a(this.a).getChildCount())
    {
      localCurrentWeatherContent = (CurrentWeatherContent)t.a(this.a).getChildAt(i);
      if ((localCurrentWeatherContent != null) && (localCurrentWeatherContent.h() != null)) {
        localCurrentWeatherContent.h().a(paramList, paramw);
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (!t.b(this.a, paramString2)) {
      if ((TextUtils.isEmpty(paramString1)) || (!t.b(this.a, paramString1)))
      {
        paramString1 = t.e(this.a);
        paramString1.a(paramString2);
        paramString1.a(this.a);
        paramString1.a();
        t.a(this.a).addView(paramString1);
        t.a(this.a).a();
        if (paramInt >= t.a(this.a).getChildCount()) {
          break label283;
        }
      }
    }
    for (;;)
    {
      t.a(this.a).a(paramInt);
      return;
      int i = 0;
      for (;;)
      {
        if (i >= t.a(this.a).getChildCount()) {
          break label184;
        }
        CurrentWeatherContent localCurrentWeatherContent = (CurrentWeatherContent)t.a(this.a).getChildAt(i);
        if ((localCurrentWeatherContent != null) && (paramString1.equals(localCurrentWeatherContent.c())))
        {
          localCurrentWeatherContent.a(paramString2);
          localCurrentWeatherContent.a();
          break;
        }
        i += 1;
      }
      label184:
      break;
      if ((TextUtils.isEmpty(paramString1)) || (t.f(this.a).a(paramString1) != null)) {
        break;
      }
      i = 0;
      label210:
      if (i < t.a(this.a).getChildCount())
      {
        paramString2 = (CurrentWeatherContent)t.a(this.a).getChildAt(i);
        if (paramString2 != null) {
          break label254;
        }
      }
      label254:
      while (!paramString1.equals(paramString2.c()))
      {
        i += 1;
        break label210;
        break;
      }
      t.a(this.a).removeView(paramString2);
      paramString2.f();
      break;
      label283:
      if (t.g(this.a) < t.a(this.a).getChildCount()) {
        paramInt = t.g(this.a);
      } else {
        paramInt = 0;
      }
    }
  }
  
  public void b()
  {
    t.d(this.a);
    int i = 0;
    while (i < t.a(this.a).getChildCount())
    {
      CurrentWeatherContent localCurrentWeatherContent = (CurrentWeatherContent)t.a(this.a).getChildAt(i);
      if ((localCurrentWeatherContent != null) && (localCurrentWeatherContent.h() != null)) {
        localCurrentWeatherContent.h().e();
      }
      i += 1;
    }
  }
  
  public void b(int paramInt)
  {
    t.d(this.a);
    int i = 0;
    while (i < t.a(this.a).getChildCount())
    {
      CurrentWeatherContent localCurrentWeatherContent = (CurrentWeatherContent)t.a(this.a).getChildAt(i);
      if ((localCurrentWeatherContent != null) && (localCurrentWeatherContent.h() != null)) {
        localCurrentWeatherContent.h().c(paramInt);
      }
      i += 1;
    }
  }
  
  public void c()
  {
    t.d(this.a);
    int i = 0;
    while (i < t.a(this.a).getChildCount())
    {
      CurrentWeatherContent localCurrentWeatherContent = (CurrentWeatherContent)t.a(this.a).getChildAt(i);
      if ((localCurrentWeatherContent != null) && (localCurrentWeatherContent.h() != null)) {
        localCurrentWeatherContent.h().f();
      }
      i += 1;
    }
  }
  
  public void c(int paramInt)
  {
    t.d(this.a);
    int i = 0;
    while (i < t.a(this.a).getChildCount())
    {
      CurrentWeatherContent localCurrentWeatherContent = (CurrentWeatherContent)t.a(this.a).getChildAt(i);
      if ((localCurrentWeatherContent != null) && (localCurrentWeatherContent.h() != null)) {
        localCurrentWeatherContent.h().d(paramInt);
      }
      i += 1;
    }
  }
  
  public void d(int paramInt)
  {
    t.d(this.a);
    int i = 0;
    while (i < t.a(this.a).getChildCount())
    {
      CurrentWeatherContent localCurrentWeatherContent = (CurrentWeatherContent)t.a(this.a).getChildAt(i);
      if ((localCurrentWeatherContent != null) && (localCurrentWeatherContent.h() != null)) {
        localCurrentWeatherContent.h().e(paramInt);
      }
      i += 1;
    }
  }
  
  public void e(int paramInt)
  {
    t.d(this.a);
    int i = 0;
    while (i < t.a(this.a).getChildCount())
    {
      CurrentWeatherContent localCurrentWeatherContent = (CurrentWeatherContent)t.a(this.a).getChildAt(i);
      if ((localCurrentWeatherContent != null) && (localCurrentWeatherContent.h() != null)) {
        localCurrentWeatherContent.h().f(paramInt);
      }
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */