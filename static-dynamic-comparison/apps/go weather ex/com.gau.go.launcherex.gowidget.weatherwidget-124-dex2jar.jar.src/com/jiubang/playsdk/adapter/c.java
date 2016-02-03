package com.jiubang.playsdk.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public abstract class c
  extends BaseAdapter
{
  protected Context b;
  protected LayoutInflater c;
  protected List d;
  
  public c(Context paramContext, List paramList)
  {
    this.b = paramContext;
    this.c = LayoutInflater.from(this.b);
    if (paramList == null)
    {
      this.d = new ArrayList();
      return;
    }
    this.d = paramList;
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      this.d = paramList;
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.d.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.d.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/adapter/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */