package com.go.weatherex.home;

import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.w;
import com.go.weatherex.b.a.g;
import com.go.weatherex.framework.e;
import com.go.weatherex.home.refresh.PullRefreshLayout;
import com.go.weatherex.viewex.CityNameSwitcher;
import com.go.weatherex.viewex.FrameImageView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class k
  extends e
{
  private k(c paramc) {}
  
  private void a(String paramString)
  {
    Toast.makeText(this.a.getActivity(), paramString, 0).show();
  }
  
  public void a()
  {
    c.b(this.a);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (c.e(this.a).e() == 1)
    {
      c.b(this.a, paramString1);
      c.a(this.a).b(paramString2, c.e(this.a).g(paramString1));
      c.b(this.a);
    }
  }
  
  public void a(List paramList, int paramInt) {}
  
  public void a(List paramList, w paramw)
  {
    c.c(this.a).b();
    if (paramw != null) {}
    switch (paramw.a)
    {
    case 2: 
    default: 
    case 1: 
      do
      {
        do
        {
          return;
        } while ((paramw.e == null) || (paramw.f == null));
        paramList = new HashMap();
        int j = paramw.e.size();
        int i = 0;
        while (i < j)
        {
          int k = ((Integer)paramw.f.get(i)).intValue();
          if ((k != 1) && (k != 2)) {
            paramList.put(paramw.e.get(i), Integer.valueOf(k));
          }
          i += 1;
        }
        paramw = c.e(this.a).a(c.d(this.a).b());
        if (paramw != null) {
          c.a(this.a).b(paramw.d(), c.e(this.a).g(paramw.c()));
        }
      } while (paramList.isEmpty());
      paramw = new StringBuffer();
      paramList = paramList.keySet().iterator();
      boolean bool = paramList.hasNext();
      while (bool)
      {
        String str = (String)paramList.next();
        paramw.append(c.e(this.a).e(str));
        bool = paramList.hasNext();
        if (bool)
        {
          paramw.append("、");
        }
        else
        {
          paramw.append(" ");
          paramw.append(this.a.getActivity().getString(2131165751));
        }
      }
      a(paramw.toString());
      return;
    }
    switch (paramw.b)
    {
    case 4: 
    case 5: 
    case 9: 
    default: 
      a(this.a.getActivity().getString(2131165752));
      return;
    case 3: 
      a(this.a.getActivity().getString(2131165748));
      return;
    case 6: 
      a(this.a.getActivity().getString(2131165755));
      return;
    case 7: 
      a(this.a.getActivity().getString(2131165756));
      return;
    case 8: 
      a(this.a.getActivity().getString(2131165757));
      return;
    }
    a(this.a.getActivity().getString(2131165758));
  }
  
  public void a(boolean paramBoolean)
  {
    c.b(this.a);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if ((!paramBoolean) || (c.e(this.a).a(paramString2) == null)) {
      return;
    }
    c.b(this.a, paramString2);
    c.b(this.a);
  }
  
  public void b()
  {
    c.b(this.a);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {}
  }
  
  public void c()
  {
    if (c.h(this.a).b())
    {
      this.a.a(false);
      c.b(this.a);
      c.i(this.a).setVisibility(8);
      g.a(this.a.getActivity().getApplicationContext()).a(c.i(this.a));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    c.a(this.a, paramBoolean);
    if (c.f(this.a))
    {
      c.g(this.a).a();
      return;
    }
    c.g(this.a).b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */