package com.jiubang.pla.a;

import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import java.util.List;

public abstract class a
  extends BaseAdapter
{
  protected List a;
  protected LayoutInflater b;
  protected c c;
  
  public a(LayoutInflater paramLayoutInflater, c paramc)
  {
    this.b = paramLayoutInflater;
    this.c = paramc;
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.clear();
    }
  }
  
  public void a(List paramList)
  {
    this.a = paramList;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.a == null) {
      return null;
    }
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/pla/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */