package com.go.weatherex.home.current.a;

import android.support.v4.app.FragmentActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.w;
import com.go.weatherex.home.current.x;
import com.go.weatherex.home.current.y;
import java.util.ArrayList;
import java.util.List;

public class a
  extends BaseAdapter
{
  private static ArrayList d = new ArrayList();
  private f a;
  private com.go.weatherex.framework.fragment.a b;
  private String c;
  private SparseArray e = new SparseArray();
  
  static
  {
    d.add(Integer.valueOf(1));
    d.add(Integer.valueOf(3));
    d.add(Integer.valueOf(2));
    d.add(Integer.valueOf(4));
    d.add(Integer.valueOf(5));
    if (GoWidgetApplication.a) {
      d.add(Integer.valueOf(6));
    }
  }
  
  public a(com.go.weatherex.framework.fragment.a parama, String paramString)
  {
    this.a = f.a(parama.getActivity().getApplicationContext());
    this.b = parama;
    this.c = paramString;
  }
  
  public Integer a(int paramInt)
  {
    return (Integer)d.get(paramInt);
  }
  
  public void a()
  {
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      ((x)this.e.valueAt(i)).k();
      i += 1;
    }
  }
  
  public void a(List paramList, w paramw)
  {
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      ((x)this.e.valueAt(i)).a(paramList, paramw);
      i += 1;
    }
  }
  
  public void b()
  {
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      ((x)this.e.valueAt(i)).j();
      i += 1;
    }
  }
  
  public void b(int paramInt)
  {
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      ((x)this.e.valueAt(i)).a(paramInt);
      i += 1;
    }
  }
  
  public void c()
  {
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      ((x)this.e.valueAt(i)).i();
      i += 1;
    }
    this.e.clear();
  }
  
  public void c(int paramInt)
  {
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      ((x)this.e.valueAt(i)).b(paramInt);
      i += 1;
    }
  }
  
  public void d()
  {
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      ((x)this.e.valueAt(i)).a();
      i += 1;
    }
  }
  
  public void d(int paramInt)
  {
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      ((x)this.e.valueAt(i)).c(paramInt);
      i += 1;
    }
  }
  
  public void e()
  {
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      ((x)this.e.valueAt(i)).b();
      i += 1;
    }
  }
  
  public void e(int paramInt)
  {
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      ((x)this.e.valueAt(i)).d(paramInt);
      i += 1;
    }
  }
  
  public void f()
  {
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      ((x)this.e.valueAt(i)).c();
      i += 1;
    }
  }
  
  public void f(int paramInt)
  {
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      ((x)this.e.valueAt(i)).e(paramInt);
      i += 1;
    }
  }
  
  public void g()
  {
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      ((x)this.e.valueAt(i)).h();
      i += 1;
    }
  }
  
  public int getCount()
  {
    if (com.go.weatherex.h.a.a(this.a.a(this.c))) {
      return d.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramInt = a(paramInt).intValue();
    paramViewGroup = (x)this.e.get(paramInt);
    paramView = paramViewGroup;
    if (paramViewGroup == null)
    {
      paramView = y.a(this.b, paramInt);
      paramView.a(this.c);
      this.e.put(paramInt, paramView);
    }
    paramView.g();
    return paramView.f();
  }
  
  public int getViewTypeCount()
  {
    return d.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */