package com.jiubang.playsdk.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.jiubang.playsdk.f;

public class e
  extends BaseAdapter
{
  private int[] a = new int[0];
  private LayoutInflater b = null;
  private Context c;
  
  public e(Context paramContext)
  {
    this.c = paramContext;
    this.b = LayoutInflater.from(paramContext);
  }
  
  public void a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null) {
      this.a = paramArrayOfInt;
    }
  }
  
  public boolean a()
  {
    return this.a == null;
  }
  
  public int getCount()
  {
    return this.a.length;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(this.a[paramInt]);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.b.inflate(com.jiubang.playsdk.g.o, null);
      paramView = new g(this, null);
      paramView.a = ((TextView)localView.findViewById(f.j));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramInt = this.a[paramInt];
      paramViewGroup.a.setText(paramInt);
      localView.setId(paramInt);
      return localView;
      paramViewGroup = (g)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */