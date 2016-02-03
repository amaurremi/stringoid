package com.pocket.o.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

class g
  extends BaseAdapter
{
  private g(f paramf) {}
  
  public String a(int paramInt)
  {
    return (String)f.a(this.a).get(paramInt);
  }
  
  public int getCount()
  {
    return f.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {
      paramView = (TextView)paramView;
    }
    for (;;)
    {
      paramView.setText(a(paramInt));
      return paramView;
      paramView = (TextView)LayoutInflater.from(this.a.g()).inflate(2130903119, paramViewGroup, false);
      paramView.setOnClickListener(this.a);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/o/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */